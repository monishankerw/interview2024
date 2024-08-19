package com.crudExample.corejava.thread.threadLifeCycle;

/*


 */


public class ThreadLifeCylce extends Thread{

    @Override
    public void run(){
        System.out.println("Running");
    }

    public static void main(String[] args) {
        ThreadLifeCylce threadLifeCylce=new ThreadLifeCylce();
        System.out.println(threadLifeCylce.getState());//new state
        threadLifeCylce.start();
        System.out.println(threadLifeCylce.getState());//runnable
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadLifeCylce.getState());
    }//yhermate state
    }

