package com.kfryc;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Cinema City", 8, 12);

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved");
        }

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved");
        }

        if(theatre.reserveSeat("C13")){
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

//
//        //Collections.reverse(seatCopy);
//        Collections.shuffle(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theater.seat");
//        printList(theatre.seats);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);   //gets the minimum from natural order (even when they are shuffled
//        Theatre.Seat maxSeat = Collections.max(seatCopy);   //gets the maximum from natural order (even when they are shuffled
//        System.out.println("Min seat number is "+ minSeat.getSeatNumber());
//        System.out.println("Max seat number is "+ maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);


//        theatre.getSeats();
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("My apologies, the seat is taken");
//        }
//
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("My apologies, the seat is taken");
//        }

    }

    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat: list){
            System.out.print(" "+ seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("==============================");
    }


//    public static void sortList(List<? extends Theatre.Seat> list){
//        for(int i=0;i<list.size()-1;i++){
//            for(int j = i+1;j<list.size();j++){
//                if(list.get(i).compareTo(list.get(j))>0){
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }


}
