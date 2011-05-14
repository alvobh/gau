VERSION 5.00
Begin {C62A69F0-16DC-11CE-9E98-00AA00574A4F} UserForm1 
   Caption         =   "Configuração Easy Lab"
   ClientHeight    =   10020
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   11025
   OleObjectBlob   =   "config.dsx":0000
   StartUpPosition =   2  'CenterScreen
End
Attribute VB_Name = "UserForm1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Public Sub CommandButton2_Click()
'verify all pin directions and optional functions


For i = 0 To 8 'check output checkboxes and store into DDR
ddr(i) = 0
AdcE(i) = 0
Next i
If CheckBox1 = True Then ddr(0) = 1
If CheckBox2 = True Then ddr(1) = 1
If CheckBox3 = True Then ddr(2) = 1
If CheckBox4 = True Then ddr(3) = 1
If CheckBox5 = True Then ddr(4) = 1
If CheckBox6 = True Then ddr(5) = 1
If CheckBox7 = True Then ddr(6) = 1
If CheckBox8 = True Then ddr(7) = 1
If CheckBox9 = True Then ddr(8) = 1

If OptionButton6 = True Then AdcE(2) = 1
If OptionButton8 = True Then AdcE(3) = 1
If OptionButton10 = True Then AdcE(4) = 1
If OptionButton12 = True Then AdcE(5) = 1
If OptionButton14 = True Then AdcE(6) = 1
If OptionButton16 = True Then AdcE(7) = 1
If OptionButton18 = True Then AdcE(8) = 1


Call SetPWM(dev, 0, 512) ' disable PWM
Icpen = 2  ' Flags for  PWM and ICP options
If OptionButton20 = True Then Icpen = 0
If (CheckBox10 = True And OptionButton20) = True Then Icpen = 1
PWMen = False
If OptionButton4 = True Then PWMen = True


Call bintodec(ddr(), DDRA) ' Send configurations to device
Call SetOutputPorts(dev, 0)
Call SetPortDirections(dev, DDRA)
'MsgBox (DDRA)

If PWMen = True Then Call SetPWM(dev, ComboBox3.ListIndex + 1, TextBox1.Text)
Form1.Knob1.Position = ComboBox3.ListIndex + 1
Pf = ComboBox3.ListIndex + 1
Form1.Knob2.Position = TextBox1.Text
Pd = TextBox1.Text
Call Icen(dev, Icpen)

AdcRes = ComboBox1.Text

If DoEEPROMRead(dev, 3, t) = 0 Then MsgBox ("Conf. salvas!") Else MsgBox ("Erro! verifique conexão")
Call Sendoutckb
'UserForm1.Unload
Unload Me
End Sub

Private Sub OptionButton10_Click()
CheckBox5 = False
CheckBox5.Enabled = False

Frame6.Enabled = True
OptionButton12.Caption = "Analog Input - Single"
OptionButton11.Enabled = True
OptionButton12.Enabled = True
End Sub

Private Sub OptionButton11_Click()
CheckBox6.Enabled = True
End Sub

Private Sub OptionButton12_Click()
CheckBox6 = False
CheckBox6.Enabled = False
End Sub

Private Sub OptionButton13_Click()
CheckBox7.Enabled = True
End Sub

Private Sub OptionButton14_Click()
CheckBox7 = False
CheckBox7.Enabled = False
End Sub

Private Sub OptionButton15_Click()
CheckBox8.Enabled = True

Frame9.Enabled = True
OptionButton17.Enabled = True
OptionButton18.Enabled = True
OptionButton18.Caption = "Analog Input - Single"
End Sub

Private Sub OptionButton16_Click()
CheckBox8 = False
CheckBox8.Enabled = False

Frame9.Enabled = True
OptionButton17.Enabled = True
OptionButton18.Enabled = True
OptionButton18.Caption = "Analog Input - Single"
End Sub

Private Sub OptionButton17_Click()
CheckBox9.Enabled = True

End Sub

Private Sub OptionButton18_Click()
CheckBox9 = False
CheckBox9.Enabled = False
End Sub

Private Sub OptionButton19_Click()
Frame4.Enabled = False
OptionButton8.Caption = "AD0 - positive pin"
OptionButton8 = True
OptionButton7.Enabled = False
OptionButton8.Enabled = False
End Sub

Private Sub OptionButton20_Click()
CheckBox3 = False
CheckBox3.Enabled = False
CheckBox10.Enabled = True
'Frame4.Enabled = True 'Applicable just to IA02
'OptionButton8.Caption = "Analog Input - Single"
'OptionButton7.Enabled = True
'OptionButton8.Enabled = True
End Sub

Private Sub OptionButton21_Click()
CheckBox5 = False
CheckBox5.Enabled = False
Frame6.Enabled = False
OptionButton12.Caption = "AD1 - positive pin"
OptionButton12 = True
OptionButton11.Enabled = False
OptionButton12.Enabled = False
CheckBox6 = False
CheckBox6.Enabled = False
End Sub

Private Sub OptionButton22_Click()
CheckBox8 = False
CheckBox8.Enabled = False

Frame9.Enabled = False
OptionButton17.Enabled = False
OptionButton18.Enabled = False
OptionButton18.Caption = "AD2 - positive pin"
CheckBox9 = True
CheckBox9.Enabled = False
End Sub

Private Sub OptionButton3_Click()
CheckBox2.Enabled = True
ComboBox3.Enabled = False
Label3.Enabled = False
TextBox1.Enabled = False
Label4.Enabled = False

'Form1.Knob1.Visible = False
'Form1.Knob2.Visible = False
End Sub

Private Sub OptionButton4_Click()
If OptionButton4 = True Then
CheckBox2 = True
CheckBox2.Enabled = False
ComboBox3.Enabled = True
Label3.Enabled = True
TextBox1.Enabled = True
Label4.Enabled = True

'Form1.Knob1.Visible = True
'Form1.Knob2.Visible = True
End If
End Sub

Private Sub OptionButton5_Click()
CheckBox3.Enabled = True
CheckBox10.Enabled = False
'Frame4.Enabled = True ' Applicable just for IA02
'OptionButton8.Caption = "Analog Input - Single"
'OptionButton7.Enabled = True
'OptionButton8.Enabled = True
End Sub

Private Sub OptionButton6_Click()
Frame4.Enabled = True
OptionButton8.Caption = "Analog Input - Single"
OptionButton7.Enabled = True
OptionButton8.Enabled = True
CheckBox3 = False
CheckBox3.Enabled = False
End Sub

Private Sub OptionButton7_Click()
CheckBox4.Enabled = True
End Sub

Private Sub OptionButton8_Click()
CheckBox4 = False
CheckBox4.Enabled = False
End Sub

Private Sub OptionButton9_Click()
CheckBox5.Enabled = True

Frame6.Enabled = True
OptionButton12.Caption = "Analog Input - Single"
OptionButton11.Enabled = True
OptionButton12.Enabled = True

End Sub

Private Sub UserForm_Activate()
OptionButton1 = True  ' Initial condition
OptionButton3 = True
OptionButton5 = True
OptionButton7 = True
OptionButton9 = True
OptionButton11 = True
OptionButton13 = True
OptionButton15 = True
OptionButton17 = True



OptionButton6.Enabled = False
OptionButton8.Enabled = False
OptionButton10.Enabled = False
OptionButton12.Enabled = False
OptionButton14.Enabled = False
OptionButton16.Enabled = False
OptionButton18.Enabled = False
OptionButton19.Enabled = False
OptionButton21.Enabled = False
OptionButton22.Enabled = False

ComboBox1.Enabled = False
Label1.Enabled = False
Label2.Enabled = False
ComboBox2.Enabled = False
'ComboBox1.AddItem
'ComboBox1.List(0, 0) = 10

If Modelo = 1 Then
OptionButton6.Enabled = True
OptionButton8.Enabled = True
OptionButton10.Enabled = True
OptionButton12.Enabled = True
OptionButton14.Enabled = True
OptionButton16.Enabled = True
OptionButton18.Enabled = True
ComboBox1.Enabled = True
Label1.Enabled = True
ComboBox1.AddItem
ComboBox1.List(0, 0) = 10
ComboBox1.AddItem
ComboBox1.List(1, 0) = 12
ComboBox1.AddItem
ComboBox1.List(2, 0) = 14
ComboBox1.Text = AdcRes
End If



For i = 0 To 14
ComboBox3.AddItem  ' PWM frequency
Next
ComboBox3.List(0, 0) = 11719
ComboBox3.List(1, 0) = 5859
ComboBox3.List(2, 0) = 2930
ComboBox3.List(3, 0) = 1465
ComboBox3.List(4, 0) = 732
ComboBox3.List(5, 0) = 366
ComboBox3.List(6, 0) = 183
ComboBox3.List(7, 0) = 92
ComboBox3.List(8, 0) = 46
ComboBox3.List(9, 0) = 23
ComboBox3.List(10, 0) = 11
ComboBox3.List(11, 0) = 5.7
ComboBox3.List(12, 0) = 2.86
ComboBox3.List(13, 0) = 1.43
ComboBox3.List(14, 0) = 0.72


If ddr(0) = 1 Then CheckBox1 = True  ' Load previous config.
If ddr(1) = 1 Then CheckBox2 = True
If ddr(2) = 1 Then CheckBox3 = True
If ddr(3) = 1 Then CheckBox4 = True
If ddr(4) = 1 Then CheckBox5 = True
If ddr(5) = 1 Then CheckBox6 = True
If ddr(6) = 1 Then CheckBox7 = True
If ddr(7) = 1 Then CheckBox8 = True
If ddr(8) = 1 Then CheckBox9 = True
If PWMen = True Then OptionButton4 = True
ComboBox3.ListIndex = Pf - 1
TextBox1.Text = Pd
If Icpen = 0 Then OptionButton20 = True
If Icpen = 1 Then OptionButton20 = True
If Icpen = 1 Then CheckBox10 = True

If AdcE(2) = 1 Then OptionButton6 = True  ' Load previous config.
If AdcE(3) = 1 Then OptionButton8 = True
If AdcE(4) = 1 Then OptionButton10 = True
If AdcE(5) = 1 Then OptionButton12 = True
If AdcE(6) = 1 Then OptionButton14 = True
If AdcE(7) = 1 Then OptionButton16 = True
If AdcE(8) = 1 Then OptionButton18 = True



End Sub

