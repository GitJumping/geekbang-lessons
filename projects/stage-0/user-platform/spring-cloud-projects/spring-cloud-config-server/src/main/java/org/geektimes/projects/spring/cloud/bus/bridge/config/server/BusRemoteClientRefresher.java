package org.geektimes.projects.spring.cloud.bus.bridge.config.server;

import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import org.springframework.cloud.bus.event.Destination;

public class BusRemoteClientRefresher  implements ApplicationListener<RefreshEvent> {
    private ApplicationEventPublisher publisher;

    private  BusProperties busProperties;

    private  Destination.Factory destinationFactory;

    public BusRemoteClientRefresher(ApplicationEventPublisher publisher, BusProperties bus,
                                    Destination.Factory destinationFactory){
        this.publisher = publisher;
        this.busProperties = bus;
        this.destinationFactory = destinationFactory;
    }


    @Override
    public void onApplicationEvent(RefreshEvent event) {
        RefreshRemoteApplicationEvent remoteEvent = new RefreshRemoteApplicationEvent(this, busProperties.getId(),
                destinationFactory.getDestination(null));
        publisher.publishEvent(remoteEvent);
    }
}
