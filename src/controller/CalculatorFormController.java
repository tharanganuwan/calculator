package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class CalculatorFormController {

    public AnchorPane root;
    public TextField txtDisplay;
    public Button btnAdd;
    public Button btnSub;
    public Button btnMul;
    public Button btnDiv;
    public boolean isOperator = false;
    public String operator = "F";
    public Button btnDot;
    public Button btnAddSub;
    public String currentOperator = "";
    public double newNumber;
    public double answer = 0;
    public boolean number = false;
    public Button btn0;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button btnEqual;
    public Button btnClear;
    public boolean isEnterDot = false;


    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) this.root.getScene().getWindow();
        primaryStage.close();
    }

    public void initialize(){
        txtDisplay.setEditable(false);
        btnDefaultColor();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtDisplay.clear();
        btnDefaultColor();
        newNumber=0;
        answer=0;
        operator="F";
        currentOperator="";
        number=false;
        error(false);
        isEnterDot=false;
    }

    public void btn0OnAction(ActionEvent actionEvent) {
        numberClick("0");
    }

    public void btn1OnAction(ActionEvent actionEvent) {
        numberClick("1");
    }

    public void btn2OnAction(ActionEvent actionEvent) {
        numberClick("2");
    }

    public void btn3OnAction(ActionEvent actionEvent) {
        numberClick("3");
    }

    public void btn4OnAction(ActionEvent actionEvent) {
        numberClick("4");
    }

    public void btn5OnAction(ActionEvent actionEvent) {
        numberClick("5");
    }

    public void btn6OnAction(ActionEvent actionEvent) {
        numberClick("6");
    }

    public void btn7OnAction(ActionEvent actionEvent) {
        numberClick("7");
    }

    public void btn8OnAction(ActionEvent actionEvent) {
        numberClick("8");
    }

    public void btn9OnAction(ActionEvent actionEvent) {
        numberClick("9");
    }

    public void btnDotOnAction(ActionEvent actionEvent) {
        btnDefaultColor();
        if(isOperator){
            txtDisplay.clear();
            isOperator=false;
        }
        if(!txtDisplay.getText().isEmpty()){
            if(!isEnterDot)
            {
                if(Double.parseDouble(txtDisplay.getText())%1==0){
                    txtDisplay.setText(txtDisplay.getText()+".");
                    number=true;
                }
            }

        }
        isEnterDot=true;
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        calculation("+",btnAdd);
    }

    public void btnSubOnAction(ActionEvent actionEvent) {
        calculation("-",btnSub);
    }

    public void btnMulOnAction(ActionEvent actionEvent) {
        calculation("x",btnMul);
    }

    public void btnDivOnAction(ActionEvent actionEvent) {
        calculation("/",btnDiv);
    }

    public void btnEqualOnAction(ActionEvent actionEvent) {
        btnDefaultColor();
        isEnterDot=false;
        switch(operator){
            case "+":
                newNumber= Double.parseDouble(txtDisplay.getText());
                answer=answer+newNumber;
                displayTex();
                number=false;
                currentOperator="+";
                operator="F";
                break;
            case "-":
                newNumber= Double.parseDouble(txtDisplay.getText());
                answer=answer-newNumber;
                displayTex();
                number=false;
                currentOperator="-";
                operator="F";
                break;
            case "x":
                newNumber= Double.parseDouble(txtDisplay.getText());
                answer=answer*newNumber;
                displayTex();
                number=false;
                currentOperator="x";
                operator="F";
                break;
            case "/":
                newNumber= Double.parseDouble(txtDisplay.getText());
                if(newNumber!=0){
                    answer = answer/newNumber;
                    displayTex();
                }else{
                    txtDisplay.setText("Error");
                    error(true);
                }
                number=false;
                currentOperator="/";
                operator="F";
                break;
            default:
                switch (currentOperator){
                    case "+":
                        answer=answer+newNumber;
                        displayTex();
                        break;
                    case "-":
                        answer=answer-newNumber;
                        displayTex();
                        break;
                    case "x":
                        answer=answer*newNumber;
                        displayTex();
                        break;
                    case "/":
                        if(newNumber!=0){
                            answer = answer/newNumber;
                            displayTex();
                        }else{
                            txtDisplay.setText("Error");
                            error(true);
                        }
                        break;
                    default:
                }
        }
    }

    public void btnDefaultColor(){
        btnAdd.setStyle("*-fx-background-color: [mainPan]");
        btnSub.setStyle("*-fx-background-color: [mainPan]");
        btnMul.setStyle("*-fx-background-color: [mainPan]");
        btnDiv.setStyle("*-fx-background-color: [mainPan]");
    }

    public void error(boolean isError){
        btn0.setDisable(isError);
        btn1.setDisable(isError);
        btn2.setDisable(isError);
        btn3.setDisable(isError);
        btn4.setDisable(isError);
        btn5.setDisable(isError);
        btn6.setDisable(isError);
        btn7.setDisable(isError);
        btn8.setDisable(isError);
        btn9.setDisable(isError);
        btnEqual.setDisable(isError);
        btnAdd.setDisable(isError);
        btnSub.setDisable(isError);
        btnMul.setDisable(isError);
        btnDiv.setDisable(isError);
        btnDot.setDisable(isError);
        btnAddSub.setDisable(isError);
    }

    public void calculation(String operatorMark,Button click){
        btnDefaultColor();
        isEnterDot=false;
        click.setStyle("-fx-background-color: #170742");
        isOperator=true;
        if (number){
            if(Objects.equals(operator, "+")){
                newNumber = Double.parseDouble(txtDisplay.getText());
                answer = answer+newNumber;
                operator=operatorMark;
                displayTex();
            }else if(operator.equals("F")){
                newNumber = Double.parseDouble(txtDisplay.getText());
                answer = newNumber;
                displayTex();
                operator=operatorMark;
            } else if(Objects.equals(operator, "-")){
                newNumber = Double.parseDouble(txtDisplay.getText());
                answer = answer-newNumber;
                operator=operatorMark;
                displayTex();
            } else if(Objects.equals(operator, "x")){
                newNumber = Double.parseDouble(txtDisplay.getText());
                answer = answer*newNumber;
                operator=operatorMark;
                displayTex();
            }
            else if(Objects.equals(operator, "/")){
                newNumber = Double.parseDouble(txtDisplay.getText());
                if(newNumber!=0){
                    answer = answer/newNumber;
                    operator=operatorMark;
                    displayTex();
                }else{
                    txtDisplay.setText("Error");
                    error(true);
                }
            }
        } else {
            operator=operatorMark;
        }
        newNumber=0;
        number=false;
    }

    public void displayTex(){
        if(answer%1==0){
            txtDisplay.setText(String.valueOf((int)answer));
        }else {
            txtDisplay.setText(String.valueOf(answer));
        }
    }

    public void numberClick(String num){
        btnDefaultColor();
        isEnterDot=false;
        if(isOperator){
            txtDisplay.clear();
            isOperator=false;
        }
        txtDisplay.setText(txtDisplay.getText()+num);
        number=true;
    }

    public void btnAddSubOnAction(ActionEvent actionEvent) {
        if(!txtDisplay.getText().isEmpty()){
            double num = Double.parseDouble(txtDisplay.getText());
            if(num!=0)
            {
                txtDisplay.clear();
                num=num*-1;
                btnDefaultColor();
                isEnterDot=false;
                if(isOperator){
                    txtDisplay.clear();
                    isOperator=false;
                }
                if(answer%1==0){
                    txtDisplay.setText(String.valueOf((int)num));
                }else {
                    txtDisplay.setText(String.valueOf(num));
                }
                number=true;
            }
        }
    }

    public void btnMinimizeOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setIconified(true);

    }
}

