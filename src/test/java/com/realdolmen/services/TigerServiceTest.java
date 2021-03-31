package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.TigerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TigerServiceTest {
    @Mock
    private TigerRepository tigerRepository;

    @InjectMocks
    private TigerService tigerService;

    @Test
    public void verifyThatGetTigersFromDbIsCalledOnce(){
        List<Tiger> tigers = tigerService.getTigers();
        Mockito.verify(tigerRepository,Mockito.times(1)).getTigersFromDb();
    }

}
