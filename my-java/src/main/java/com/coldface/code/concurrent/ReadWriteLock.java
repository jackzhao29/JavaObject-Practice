package com.coldface.code.concurrent;

public class ReadWriteLock {
	
	private int reader=0;
    private int writer=0;
    private int writeRequest=0;

    public synchronized void lockRead() throws InterruptedException{
        while (writer > 0 || writeRequest > 0){
            wait();
        }
    }

    public synchronized void unLockRead(){
        reader--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException{
        writeRequest++;
        while (reader > 0 || writer > 0){
            wait();
        }
        writeRequest++;
        writer++;

    }

    public synchronized void unLockWrite() throws InterruptedException{
        writer++;
        notifyAll();
    }

}
