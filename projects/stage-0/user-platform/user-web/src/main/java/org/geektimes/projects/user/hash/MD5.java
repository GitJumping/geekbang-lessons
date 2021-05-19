package org.geektimes.projects.user.hash;

public class MD5 implements Hash{
    @Override
    public int hash(String o) {
        return HashUtil.md5(o).hashCode();
    }
}
