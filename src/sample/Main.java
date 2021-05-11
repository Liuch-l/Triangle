package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;


public class Main extends Application {
    //文本框
    TextField textField = new TextField();
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();

    //标签
    Label label = new Label("请输入三个1到200的整数：");
    Label label1 = new Label("A");
    Label label2 = new Label("B");
    Label label3 = new Label("C");
    Label label4 = new Label("形状");

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("判断三角形的类型");
        //判断形状按钮
        Button Judge_bt = new Button("判断形状");
        //重新输入按钮
        Button Anew_bt = new Button("重新输入");


        //绑定按钮事件
        Anew_bt.setOnAction(e -> DeleteAnew());
        Judge_bt.setOnAction(e -> JudgeShape());




        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(label,0,0);
        pane.add(label1,0,1);
        pane.add(textField,1,1);
        pane.add(label2,0,2);
        pane.add(textField1,1,2);
        pane.add(label3,0,3);
        pane.add(textField2,1,3);
        pane.add(label4,0,4);
        pane.add(textField3,1,4);
        pane.add(Judge_bt,0,5);
        pane.add(Anew_bt,1,5);


        primaryStage.setScene(new Scene(pane, 400, 275));
        //禁止改变舞台大小
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void JudgeShape() {
        try {
            int A = Integer.valueOf(textField.getText());
            int B = Integer.valueOf(textField1.getText());
            int C = Integer.valueOf(textField2.getText());

            if (compare() == 1) {
                JOptionPane.showMessageDialog(null,"参数输入超限！");
            } else {
                //判别是否为三角形。
                if (A > 0 && B > 0 && C > 0 && (A + B) > C && (A + C) > B && (B + C) > A) {
                    //判别是三角形类型
                    if (A == B && B == C) {
                        textField3.setText("等边三角形");
                        return;
                    } else if (A == B || B == C || A == C) {
                        textField3.setText("等腰三角形");
                        return;
                    } else {
                        textField3.setText("一般三角形");
                        return;
                    }
                } else {

                    textField3.setText("不能构成三角形");
                    return;
                }
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"参数输入非法！");
        }

    }

    private int compare() {
        try {
            int A = Integer.valueOf(textField.getText());
            int B = Integer.valueOf(textField1.getText());
            int C = Integer.valueOf(textField2.getText());
            if (A > 0 && A <= 200 && B > 0 && B <= 200 && C > 0 && C <= 200) {
                return 0;
            } else {
                return 1;
            }
        }
        catch (Exception e)
        {
            return 3;
        }
    }

    private void DeleteAnew() {
        textField.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");

    }


    public static void main(String[] args) {
        launch(args);
    }



}
