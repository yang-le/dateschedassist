package com.example.yangle.dateschedassist;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

public class MainActivityTest extends ApplicationTestCase<Application> {

    public MainActivityTest() {
        super(Application.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testDummy() throws Exception {
        assertEquals(1, 0);
    }

    @SmallTest
    public void testPreconditions() throws Exception {

    }
}
