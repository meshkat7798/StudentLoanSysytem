package service;

import base.service.BaseEntityService;
import entity.Address;
@SuppressWarnings("unused")
public interface AddressService extends BaseEntityService<Address,Integer> {
    boolean isMetropolis(String city);
    boolean isCapital(String city);
}
