package org.seandragon.jfinal.demo.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * Created by sd on 17/2/16.
 */
public class RootController extends Controller {

    @ActionKey("/")
    public void index() {
        renderJsp("/index.jsp");
    }
}
