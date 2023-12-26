package repository;

import base.repository.BaseEntityRepository;
import entity.Address;
import entity.CreditCard;
@SuppressWarnings("unused")
public interface AddressRepository extends BaseEntityRepository<Address, Integer> {
  // Address fidById(Integer id);
}
