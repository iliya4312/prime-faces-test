package ru.shoklevs.pftest.proxy;

public class DateServiceProxy implements ru.shoklevs.pftest.proxy.DateService {
  private String _endpoint = null;
  private ru.shoklevs.pftest.proxy.DateService dateService = null;
  
  public DateServiceProxy() {
    _initDateServiceProxy();
  }
  
  public DateServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDateServiceProxy();
  }
  
  private void _initDateServiceProxy() {
    try {
      dateService = (new ru.shoklevs.pftest.proxy.DateServiceServiceLocator()).getDateServicePort();
      if (dateService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dateService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dateService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dateService != null)
      ((javax.xml.rpc.Stub)dateService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ru.shoklevs.pftest.proxy.DateService getDateService() {
    if (dateService == null)
      _initDateServiceProxy();
    return dateService;
  }
  
  public java.util.Calendar getDate() throws java.rmi.RemoteException{
    if (dateService == null)
      _initDateServiceProxy();
    return dateService.getDate();
  }
  
  
}