/**
 * DateServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.shoklevs.pftest.proxy;

import ru.shoklevs.pftest.hibernate.utils.VariablesUtil;

public class DateServiceServiceLocator extends org.apache.axis.client.Service implements ru.shoklevs.pftest.proxy.DateServiceService {

    public DateServiceServiceLocator() {
    }


    public DateServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DateServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DateServicePort
    private java.lang.String DateServicePort_address = VariablesUtil.getValue(VariablesUtil.__WS_ENDPOINT_PORT);

    public java.lang.String getDateServicePortAddress() {
        return DateServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DateServicePortWSDDServiceName = "DateServicePort";

    public java.lang.String getDateServicePortWSDDServiceName() {
        return DateServicePortWSDDServiceName;
    }

    public void setDateServicePortWSDDServiceName(java.lang.String name) {
        DateServicePortWSDDServiceName = name;
    }

    public ru.shoklevs.pftest.proxy.DateService getDateServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DateServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDateServicePort(endpoint);
    }

    public ru.shoklevs.pftest.proxy.DateService getDateServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.shoklevs.pftest.proxy.DateServicePortBindingStub _stub = new ru.shoklevs.pftest.proxy.DateServicePortBindingStub(portAddress, this);
            _stub.setPortName(getDateServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDateServicePortEndpointAddress(java.lang.String address) {
        DateServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ru.shoklevs.pftest.proxy.DateService.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.shoklevs.pftest.proxy.DateServicePortBindingStub _stub = new ru.shoklevs.pftest.proxy.DateServicePortBindingStub(new java.net.URL(DateServicePort_address), this);
                _stub.setPortName(getDateServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DateServicePort".equals(inputPortName)) {
            return getDateServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.shoklevs.ru/", "DateServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.shoklevs.ru/", "DateServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DateServicePort".equals(portName)) {
            setDateServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
