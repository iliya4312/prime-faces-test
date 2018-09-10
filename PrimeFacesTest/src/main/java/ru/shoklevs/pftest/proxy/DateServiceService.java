/**
 * DateServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.shoklevs.pftest.proxy;

public interface DateServiceService extends javax.xml.rpc.Service {
    public java.lang.String getDateServicePortAddress();

    public ru.shoklevs.pftest.proxy.DateService getDateServicePort() throws javax.xml.rpc.ServiceException;

    public ru.shoklevs.pftest.proxy.DateService getDateServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
