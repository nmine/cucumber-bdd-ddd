package be.nmine.restaurant.orderpicking;

public interface NotificationService {
    void notify(Notification notification);

    Notification getNotification();
}
