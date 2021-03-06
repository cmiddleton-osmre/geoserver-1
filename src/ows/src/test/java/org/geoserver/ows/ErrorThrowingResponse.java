/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.ows;

import java.io.IOException;
import java.io.OutputStream;

import org.geoserver.platform.Operation;
import org.geoserver.platform.ServiceException;


public class ErrorThrowingResponse extends Response {
    public ErrorThrowingResponse() {
        super(Message.class);
    }

    public String getMimeType(Object value, Operation operation) {
        return "text/plain";
    }

    public void write(Object value, OutputStream output, Operation operation)
        throws IOException {
        Message message = (Message) value;
        output.write(message.message.getBytes());
        throw new ServiceException("Whoops, something gone wrong!");
    }

    public void abort(Object value, OutputStream output, Operation operation)
        throws IOException {
    }
}
