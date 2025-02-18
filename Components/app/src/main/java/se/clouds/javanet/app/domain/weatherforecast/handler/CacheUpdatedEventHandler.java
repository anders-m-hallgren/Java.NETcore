package se.clouds.javanet.app.domain.weatherforecast.handler;

import se.clouds.javanet.app.domain.weatherforecast.notification.UpdatedCacheEvent;
import se.clouds.javanet.core.di.Di;
import se.clouds.javanet.core.mediator.IMediator;
import se.clouds.javanet.core.mediator.INotificationHandler;
import se.clouds.javanet.core.mediator.MediatR;

public class CacheUpdatedEventHandler implements INotificationHandler<UpdatedCacheEvent> {

    private MediatR<UpdatedCacheEvent> mediatr = (MediatR) Di.GetSingleton(IMediator.class, MediatR.class);

    public CacheUpdatedEventHandler() {
        Register(new UpdatedCacheEvent());
    }

    public Void Handle(UpdatedCacheEvent event) {
        return null;
    }

    public void Register(UpdatedCacheEvent event) {
        var subscriberTask = new Task(event);
        //mediatr.addSubscriber(event, subscriberTask);
    }

    public void Publish(UpdatedCacheEvent event) {
        // var task = getTask(handler, request);
      //  mediatr.Publish(event); // not needed ActionResult?
    }

    public class Task implements Runnable {
        private UpdatedCacheEvent event;

        public Task(UpdatedCacheEvent event) {
            super();
            this.event = event;
        }
        @Override
        public void run() {
            System.out.println("Is subscriber for " + event);
        }

    }
}
