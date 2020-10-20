package com.titanic.javatest.reflection.di;

import org.springframework.stereotype.Service;

@Service
public class ShoeService {

    @Inject
    public ShoeRepository shoeRepository;

}
