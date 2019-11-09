package com.example.dhruvmittal.studentdelegatesapp.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;

public class ByteArrayDataSource implements DataSource {
    private byte[] data; //Creates an array for the data
    private String type;

    public ByteArrayDataSource(byte[] data, String type) {
        super();
        this.data = data;
        this.type = type;
    }

    public ByteArrayDataSource(byte[] data) { //Overloading constructors
        super();
        this.data = data;
    }

    public void setType(String type) { //Setter
        this.type = type;
    }

    public String getContentType() { //Getter
        if (type == null)
            return "application/octet-stream";
        else
            return type;
    }

    public InputStream getInputStream() throws IOException { //Creates an input stream
        return new ByteArrayInputStream(data);
    }

    public String getName() {
        return "ByteArrayDataSource";
    }

    public OutputStream getOutputStream() throws IOException { //Output stream is not supported yet
        throw new IOException("Not Supported");
    }
}
