package se.clouds.javanet.services;

import java.util.LinkedList;

import se.clouds.javanet.core.di.IServiceCollection;
import se.clouds.javanet.core.flow.pipeline.IPipeResponse;
import se.clouds.javanet.core.flow.pipeline.Step;
import se.clouds.javanet.core.service.IMessageService;

public class SmsService implements IMessageService, Step<IPipeResponse, IPipeResponse>  {

    public static void Use(IServiceCollection serviceCollection, LinkedList<Step<IPipeResponse, IPipeResponse>> app) {
        var service = serviceCollection.services.stream()
            .filter(s -> (s.getClass() == SmsService.class))
            .findFirst()
            .get();
        app.add(service);
    }

    @Override
    public IServiceCollection.Builder Add(IServiceCollection.Builder builder) {
        builder.services.add(this);
        return builder;
    }

	@Override
	public void sendMessage(String msg, String rec) {
		//logic to send SMS
		System.out.println("SMS sent to "+rec+ " with Message="+msg);
	}

    @Override
    public IPipeResponse Process(IPipeResponse input) {
        System.out.println("-- processing SmsService START Input: " + input.Response());
        input.Add(" 2) Sms");
        System.out.println("-- processing SmsService STOP --");
        return input;
    }


}

