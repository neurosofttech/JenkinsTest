package pagesTast;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testing {

@BeforeMethod
public  void beforemethodTest(){
    System.out.println("Open Browser");


}

   @Test
    public void test1(){


        System.out.println("Testing radiobutton");



    }

    @Test
    public void test2(){


        System.out.println("Testing checkbox");


    }
    @Test
    public void test3(){


        System.out.println("Testing dropdown");


    }

    @AfterMethod
    public void aftertest(){

        System.out.println("Close browser");

    }


}
