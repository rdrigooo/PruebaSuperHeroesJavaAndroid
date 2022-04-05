package com.desafiolatam.pruebasuperheroes.viewModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HeroesViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Observer<SuperheroeItem>superheroeItemObserver;

    @Mock
    private Observer<List<SuperheroeItem>>listObserver;
    private HeroesViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        viewModel = new HeroesViewModel();
        viewModel.getDetalleHeroe().observeForever(superheroeItemObserver);
        viewModel.getListaHeroe().observeForever(listObserver);

    }

    @Test
    public void lista() throws InterruptedException {
        viewModel.llamarApi();
        Thread.sleep(3000);
        List<SuperheroeItem>heroe = viewModel.getListaHeroe().getValue();
        verify(listObserver).onChanged(viewModel.getListaHeroe().getValue());



    }
}