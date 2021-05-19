package org.geektimes.projects.user.hash;

import java.util.*;

public class ConsistentHashImpl {
    private Hash myHash;

    ConsistentHashImpl(Hash ihash) {
        this.myHash = ihash;
    }

    private static final int VN_SUM = 150;//虚拟节点个数
    private static final int DATA_ACCOUNT = 1000000;//100w kv数据
    private static List<String> realNode = new ArrayList<>();
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();
    private static SortedMap<Integer, String> newSortedMap = new TreeMap<>();

    private List<Integer> initData () {
        List<Integer> datas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < DATA_ACCOUNT; i++  ) {
            datas.add(random.nextInt());
        }
        return datas;
    }

    public void initNode(int n , SortedMap sortedMap) {
        for (int i = 0; i < n; i++) {
            realNode.add("192.168.0." + i);
        }
        for (String s : realNode) {
            for (int i = 0; i < VN_SUM; i++) {
                String virtualNodeName = s + "VN" + String.valueOf(i);
                int key = myHash.hash(virtualNodeName);
                sortedMap.put(key, s);
            }
        }
    }

    public String getNode(String keyString, SortedMap<Integer,String> sortedMap) {
        if (sortedMap == null) return null;
        int hash = myHash.hash(keyString);
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        hash = subMap.isEmpty() ? sortedMap.firstKey() : subMap.firstKey();
        return sortedMap.get(hash);
    }

    public static void analyze(Map<String, Integer> nodeCount, int dataNum, int nodeNum) {
        double average = (double) dataNum / nodeNum;

        IntSummaryStatistics s1
                = nodeCount.values().stream().mapToInt(Integer::intValue).summaryStatistics();
        int max = s1.getMax();
        int min = s1.getMin();
        int range = max - min;
        double standardDeviation
                = nodeCount.values().stream().mapToDouble(n -> Math.abs(n - average)).summaryStatistics().getAverage();

        System.out.println(String.format("平均值：%.2f", average));
        System.out.println(String.format("最大值：%d,（%.2f%%）", max, 100.0 * max / average));
        System.out.println(String.format("最小值：%d,（%.2f%%）", min, 100.0 * min / average));
        System.out.println(String.format("极差：%d,（%.2f%%）", range, 100.0 * range / average));
        System.out.println(String.format("标准差：%.2f,（%.2f%%）", standardDeviation, 100.0 * standardDeviation / average));
    }



    public static void main(String[] args) {
        ConsistentHashImpl consistentHash = new ConsistentHashImpl(new KetamaHash());
        List<Integer> datas = consistentHash.initData();
        consistentHash.initNode(10,sortedMap);

        Map<String,Integer> dataCount = new HashMap<>();
        for (Integer data: datas) {
            String node  = consistentHash.getNode(data.toString(),sortedMap);
            //   System.out.println("数据"+data.toString() + "分配到了节点：" + node );
            if (dataCount.containsKey(node)) {
                dataCount.put(node,dataCount.get(node) + 1);
            } else {
                dataCount.put(node,1);
            }
        }
        analyze(dataCount,DATA_ACCOUNT,10);

        //计算节点数据迁移量
        int migrateCount = 0;
        consistentHash.initNode(12,newSortedMap);
        //consistentHashWithVN.initData(11);
        for (Integer data : datas) {
            String node = consistentHash.getNode(data.toString(),sortedMap );
            String newNode = consistentHash.getNode(data.toString(),newSortedMap );
            if (!node.equals(newNode)) {
                migrateCount++;
            }
        }
        System.out.println(String.format("数据迁移量：%d（%.2f%%）", migrateCount, migrateCount * 100.0 / datas.size()));


    }

}
