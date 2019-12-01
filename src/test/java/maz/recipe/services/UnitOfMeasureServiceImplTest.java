package maz.recipe.services;

import maz.recipe.commands.UnitOfMeasureCommand;
import maz.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import maz.recipe.domain.UnitOfMeasure;
import maz.recipe.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(repository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUom() throws Exception {

        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure unit1 = new UnitOfMeasure();
        unit1.setId(1L);
        unitOfMeasures.add(unit1);

        UnitOfMeasure unit2 = new UnitOfMeasure();
        unit2.setId(2L);
        unitOfMeasures.add(unit2);

        when(repository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMeasureCommand> commands = service.listAllUom();

        //then
        assertEquals(2, commands.size());
        verify(repository, times(1)).findAll();
    }

}