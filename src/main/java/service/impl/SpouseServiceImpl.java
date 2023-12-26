package service.impl;

import entity.person.Spouse;
import repository.SpouseRepository;
import service.SpouseService;


@SuppressWarnings("unused")
public class SpouseServiceImpl  extends  PersonServiceImpl<Spouse, SpouseRepository> implements SpouseService {
    public SpouseServiceImpl(SpouseRepository repository) {
        super(repository);
    }
}