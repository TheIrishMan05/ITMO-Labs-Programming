package Locations;

import Enums.TraitsOfClock;
import Enums.TraitsOfFlowers;
import Humans.Babies;
import Humans.Snufkin;

public class Lobby extends Room {

    private final Clock clock = new Clock(TraitsOfClock.STOPPED);
    private final Table table = new Table();
    private final Table.Flowers flowers = table.new Flowers(TraitsOfFlowers.FADED);
    private int amountOfPots = 0;

    @Override
    public void describe() {
        System.out.println("В прихожей " + table + ", на котором " + flowers + ". На стене "
                + clock);
    }


    public void doActivities(Snufkin snufkin, Babies babies) {
        this.describe();
        snufkin.descend(babies);
        snufkin.putPot(this);
        babies.moveToHuman(snufkin);
        snufkin.smoke(babies);
    }

    public void bringPot(int amount) {
        this.setAmountOfPots(this.getAmountOfPots() + amount);
    }

    public int getAmountOfPots() {
        return amountOfPots;
    }

    public void setAmountOfPots(int amountOfPots) {
        if (this.amountOfPots >= 0) {
            this.amountOfPots = amountOfPots;
        }
    }

    class Clock {
        private TraitsOfClock status;

        Clock(TraitsOfClock status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return " висели " + this.getStatus() + " часы.";
        }

        public TraitsOfClock getStatus() {
            return status;
        }

        public void setStatus(TraitsOfClock status) {
            this.status = status;
        }
    }

    class Table {
        @Override
        public String toString() {
            return " стоял стол ";
        }

        class Flowers {
            private final TraitsOfFlowers status;

            Flowers(TraitsOfFlowers status) {
                this.status = status;
            }

            public TraitsOfFlowers getStatus() {
                return status;
            }

            @Override
            public String toString() {
                if (Math.random() >= 0.5) {
                    clock.setStatus(TraitsOfClock.WORKING);
                } else {
                    clock.setStatus(TraitsOfClock.STOPPED);
                }
                return " стояли " + this.getStatus() + " цветы ";
            }
        }
    }
}
