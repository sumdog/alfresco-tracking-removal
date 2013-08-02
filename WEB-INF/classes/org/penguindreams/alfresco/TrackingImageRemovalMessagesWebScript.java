/*
 * Copyright (C) 2005-2010 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Modified by PenguinDreams to get rid of the phone home stats PNG - Sumit <sumit@penguindreamss.org>
 */

/*
* There is an Enterprise overlay for this file
*/

package org.penguindreams.alfresco;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.extensions.surf.util.I18NUtil;
import org.springframework.extensions.surf.util.StringBuilderWriter;
import org.springframework.extensions.webscripts.WebScriptException;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.extensions.webscripts.json.JSONWriter;

/**
 * WebScript responsible for returning a JavaScript response containing a JavaScript
 * associative array of all I18N messages name/key pairs installed on the web-tier.
 * <p>
 * The JavaScript object is created as 'Alfresco.messages' - example usage:
 * <code>
 * var msg = Alfresco.messages["messageid"];
 * </code>
 *
 * @author Kevin Roast
 */
public class TrackingImageRemovalMessagesWebScript extends org.springframework.extensions.webscripts.MessagesWebScript
{
    /**
     * Generate the message for a given locale.
     *
     * @param locale    Java locale format
     *
     * @return messages as JSON string
     *
     * @throws IOException
     */
    @Override
    protected String generateMessages(WebScriptRequest req, WebScriptResponse res, String locale) throws IOException
    {
        Writer writer = new StringBuilderWriter(8192);
        writer.write("if (typeof Alfresco == \"undefined\" || !Alfresco) {var Alfresco = {};}\r\n");
        writer.write("Alfresco.messages = Alfresco.messages || {global: null, scope: {}}\r\n");
        writer.write("Alfresco.messages.global = ");
        JSONWriter out = new JSONWriter(writer);

        try
        {
            out.startObject();
            Map<String, String> messages = I18NUtil.getAllMessages(I18NUtil.parseLocale(locale));
            for (Map.Entry<String, String> entry : messages.entrySet())
            {
                out.writeValue(entry.getKey(), entry.getValue());
            }
            out.endObject();
        }
        catch (IOException jsonErr)
        {
            throw new WebScriptException("Error building messages response.", jsonErr);
        }
        writer.write(";\r\n");

        // start logo 
        // community logo

        //Sumit - PenguinDreams - Edited to remove this image as it's a phone-home for Alfresco to gather software stats.
        //  It's in two places; removed below as well

        //final String serverPath = req.getServerPath();
        //final int schemaIndex = serverPath.indexOf(':');
        //writer.write("window.setTimeout(function(){(document.getElementById('alfresco-yuiloader')||document.createElement('div')).innerHTML = '<img src=\"");
        //writer.write(serverPath.substring(0, schemaIndex));
        //writer.write("://www.alfresco.com/assets/images/logos/community-4.0-share.png\" alt=\"*\" style=\"display:none\"/>\'}, 100);\r\n");
        // end logo

        return writer.toString();
    }

    @Override
    protected String getMessagesPrefix(WebScriptRequest req, WebScriptResponse res, String locale) throws IOException
    {
        return "if (typeof Alfresco == \"undefined\" || !Alfresco) {var Alfresco = {};}\r\nAlfresco.messages = Alfresco.messages || {global: null, scope: {}}\r\nAlfresco.messages.global = ";
    }

    @Override
    protected String getMessagesSuffix(WebScriptRequest req, WebScriptResponse res, String locale) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        sb.append(";\r\n");

        //Sumit - PenguinDreams - removed; see above

        // start logo 
        // community logo
        //final String serverPath = req.getServerPath();
        //final int schemaIndex = serverPath.indexOf(':');
        //sb.append("window.setTimeout(function(){(document.getElementById('alfresco-yuiloader')||document.createElement('div')).innerHTML = '<img src=\"");
        //sb.append(serverPath.substring(0, schemaIndex));
        //sb.append("://www.alfresco.com/assets/images/logos/community-4.0-share.png\" alt=\"*\" style=\"display:none\"/>\'}, 100);\r\n");
        // end logo
        return sb.toString();
    }
}
