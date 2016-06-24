package com.coldface.code.akka.dispatcher;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * 类ControlActor.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年6月24日下午6:09:45
 */
public class ControlActor extends UntypedActor {

    /*
     * (non-Javadoc)
     * 
     * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
     */
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof StartCommand) {
            List<ActorRef> actors = createActors(((StartCommand) message).getActorCount());
            for (ActorRef actorRef : actors) {
                actorRef.tell("Insert", ActorRef.noSender());
            }
        }

    }

    private List<ActorRef> createActors(int actorCount) {
        Props props = Props.create(WriterActor.class).withDispatcher("writer-dispatcher");
        List<ActorRef> actors = new ArrayList<ActorRef>(actorCount);
        for (int i = 0; i < actorCount; i++) {
            actors.add(getContext().actorOf(props, "writer_" + i));
        }
        return actors;
    }

}
