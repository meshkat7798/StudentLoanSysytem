package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Address;
import repository.AddressRepository;
import service.AddressService;


@SuppressWarnings("unused")
public class AddressServiceImpl extends BaseEntityServiceImpl<Address, Integer, AddressRepository> implements AddressService {
    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }



    @Override
    public boolean isMetropolis(String city) {
        String[] metropolisCities = new String[]{"gilan","isfahan","azarbaijan-sharghi",
        "fars","khouzestan", "qom","khorasan-razavi" ,"alborz"};
        boolean isMetro = false;
        for (String metropolisCity : metropolisCities) {
            if (metropolisCity.equalsIgnoreCase(city)) {
                isMetro = true;
                break;
            }
        }
       return isMetro;
    }

    @Override
    public boolean isCapital(String city) {
        return city.equalsIgnoreCase("tehran");
    }

}
