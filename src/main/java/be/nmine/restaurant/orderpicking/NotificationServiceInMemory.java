package be.nmine.restaurant.orderpicking;

public class NotificationServiceInMemory implements NotificationService {
    public Notification notification;
    @Override
    public void notify(Notification notification) {
        this.notification = notification;
    }

    @Override
    public Notification getNotification() {
        return notification;
    }
}
