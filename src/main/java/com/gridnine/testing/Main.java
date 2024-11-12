package com.gridnine.testing;

import com.gridnine.testing.model.*;
import com.gridnine.testing.service.predicates.ArrivalBeforeDeparturePredicateImpl;
import com.gridnine.testing.service.predicates.DepartureBeforeNowPredicateImpl;
import com.gridnine.testing.service.FlightUtils;
import com.gridnine.testing.service.predicates.TransferMoreThanTwoHoursPredicateImpl;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        String inCmd = "";

        Messages.printHelp();
        try (Scanner scanner = new Scanner(System.in)){
            do {
                System.out.print(Messages.MSG_ENTER);
                inCmd = scanner.nextLine();

                switch (inCmd){
                    case Commands.CMD_FULL_LIST:
                        flightList.stream().forEach(System.out::println);
                        break;
                    case Commands.CMD_FLT_1:
                        FlightUtils.filter(flightList, new Predicate[]{
                                        new DepartureBeforeNowPredicateImpl().negate()}).
                                stream().forEach(System.out::println);
                        break;
                    case Commands.CMD_FLT_2:
                        FlightUtils.filter(flightList, new Predicate[]{
                                        new ArrivalBeforeDeparturePredicateImpl().negate()}).
                                stream().forEach(System.out::println);
                        break;
                    case Commands.CMD_FLT_3:
                        FlightUtils.filter(flightList, new Predicate[]{
                                        new TransferMoreThanTwoHoursPredicateImpl().negate()}).
                                stream().forEach(System.out::println);
                        break;
                }
            } while (!inCmd.equals(Commands.CMD_EXIT));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}