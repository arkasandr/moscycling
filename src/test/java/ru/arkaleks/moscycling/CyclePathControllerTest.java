//package ru.arkaleks.moscycling;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.hamcrest.Matchers.is;
//
//public class CyclePathControllerTest {
//
//    @Test
//    public void whenAddTwoElements() {
//        CyclePathController ctrl = new CyclePathController();
//        ctrl.saveOrUpdate(new CyclePath(1, new Cells()), 1);
//        ctrl.saveOrUpdate(new CyclePath(2, new Cells()), 2);
//        ctrl.saveOrUpdate(new CyclePath(3, new Cells()), 3);
//        assertThat(ctrl.getAllCyclePath().size(), is(2));
//    }
//
//}