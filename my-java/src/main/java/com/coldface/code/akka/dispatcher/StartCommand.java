package com.coldface.code.akka.dispatcher;

import java.io.Serializable;

/**
 * 类StartCommand.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年6月24日下午6:07:00
 */
public class StartCommand implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2363609037813949700L;
    private int actorCount = 0;

    public StartCommand() {}

    public StartCommand(int actorCount) {
        this.actorCount = actorCount;
    }

    /**
     * @return the actorCount
     */
    public int getActorCount() {
        return actorCount;
    }

    /**
     * @param actorCount the actorCount to set
     */
    public void setActorCount(int actorCount) {
        this.actorCount = actorCount;
    }



}
