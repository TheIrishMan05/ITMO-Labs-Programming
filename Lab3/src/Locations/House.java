package Locations;

import Enums.ObjectStatus;
import Interfaces.CloseAble;

public class House {
    private final Lobby lobby = new Lobby();
    private final Kitchen kitchen = new Kitchen();
    private final Storeroom storeroom = new Storeroom();

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public Storeroom getStoreroom() {
        return storeroom;
    }

    public class Door implements CloseAble {
        private ObjectStatus status;

        public Door(ObjectStatus status) {
            this.status = status;
        }

        public ObjectStatus getStatus() {
            return status;
        }

        public void setStatus(ObjectStatus status) {
            this.status = status;
        }

        public boolean isClosed() {
            return this.getStatus().equals(ObjectStatus.CLOSED);
        }
    }
}
