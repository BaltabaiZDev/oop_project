package university.interfaces;

import java.util.List;

public interface Messageable {
    void sendMessage(String text);
    List<String> viewInbox();
}
