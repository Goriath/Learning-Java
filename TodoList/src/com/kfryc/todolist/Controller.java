package com.kfryc.todolist;

import com.kfryc.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView todoListView;
    @FXML
    private TextArea textArea;
    @FXML
    private Label labelDeadline;

    public void initialize(){
        TodoItem item1 = new TodoItem("Buy champagne",
                "Buy champagne for New Years",
                LocalDate.of(2018, Month.DECEMBER, 31));
        TodoItem item2 = new TodoItem("Doctor's appointment",
                "Go to doctor at Luxmed. Bring paperwork",
                LocalDate.of(2019, Month.JANUARY, 6));
        TodoItem item3 = new TodoItem("Buy flowers for Anna",
                "Anna's 32nd Birthday",
                LocalDate.of(2019, Month.JANUARY, 30));
        TodoItem item4 = new TodoItem("Mom's birthday",
                "Travel to hometown and buy flowers",
                LocalDate.of(2018, Month.DECEMBER, 31));
        TodoItem item5 = new TodoItem("Anniversary of friendship with Anna",
                "Another year of friendship with Anna, reserve a table at Pimiento restaurant",
                LocalDate.of(2019, Month.JANUARY, 8));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        //With addListener on todoListView we do not need onMouseClick anymore
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if(t1 != null){
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    textArea.setText(item.getDetails());
                    labelDeadline.setText(item.getDeadline().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }

//    @FXML
//    public void handleClickListView(){
//        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
//        textArea.setText(item.getDetails());
//        labelDeadline.setText(item.getDeadline().toString());
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        textArea.setText(sb.toString());
//    }
}
