/*
* @author  Oleg Varaksin (ovaraksin@googlemail.com)
* $$Id$$
*/

package com.googlecode.whiteboard.controller;

import com.googlecode.whiteboard.model.Whiteboard;
import org.apache.commons.configuration.ConfigurationException;

import java.util.HashMap;
import java.util.Map;

public class WhiteboardsManager
{
    private Map<String, Whiteboard> whiteboards = new HashMap<String, Whiteboard>();
    //private int expiredTime;

    public WhiteboardsManager() throws ConfigurationException {
        //Configuration config = new PropertiesConfiguration("wb-configuration.properties");
        //expiredTime = config.getInt("whiteboard.expiredTime", 30);
    }

    public synchronized void addWhiteboard(Whiteboard whiteboard) {
        whiteboards.put(whiteboard.getUuid(), whiteboard);
    }

    public synchronized Whiteboard updateWhiteboard(Whiteboard whiteboard) {
        return whiteboards.put(whiteboard.getUuid(), whiteboard);
    }

    public synchronized void removeWhiteboard(Whiteboard whiteboard) {
        whiteboards.remove(whiteboard.getUuid());
    }

    public Whiteboard getWhiteboard(String uuid) {
        return whiteboards.get(uuid);
    }
}
