VERSION 5.00
Object = "{86135EDC-6265-45AA-8A47-6C463280490B}#1.0#0"; "AudioControls2.ocx"
Object = "{D38FB244-0F4A-11D5-A7D5-0050BF4C4B69}#5.0#0"; "ScottsLED.ocx"
Object = "{C0C352DE-20C8-4F72-99F3-5164B80FA6E3}#13.2#0"; "CF.ocx"
Begin VB.Form Form1 
   BackColor       =   &H8000000A&
   Caption         =   "Easy Lab"
   ClientHeight    =   5760
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   10710
   LinkTopic       =   "Form1"
   ScaleHeight     =   5760
   ScaleWidth      =   10710
   StartUpPosition =   3  'Windows Default
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   2520
      TabIndex        =   43
      Text            =   "0"
      Top             =   1080
      Width           =   735
   End
   Begin CF.ConfigFile ConfigFile1 
      Left            =   4080
      Top             =   2640
      _ExtentX        =   4471
      _ExtentY        =   1296
   End
   Begin VB.Timer Timer1 
      Interval        =   400
      Left            =   8880
      Top             =   600
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc9 
      Height          =   420
      Left            =   10200
      TabIndex        =   14
      Top             =   5040
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc8 
      Height          =   420
      Left            =   10200
      TabIndex        =   13
      Top             =   4320
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc7 
      Height          =   420
      Left            =   10200
      TabIndex        =   12
      Top             =   3600
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc6 
      Height          =   420
      Left            =   10200
      TabIndex        =   11
      Top             =   2040
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc5 
      Height          =   420
      Left            =   10200
      TabIndex        =   10
      Top             =   1320
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc4 
      Height          =   420
      Left            =   2640
      TabIndex        =   9
      Top             =   5040
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc3 
      Height          =   420
      Left            =   2640
      TabIndex        =   8
      Top             =   3840
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc2 
      Height          =   420
      Left            =   2640
      TabIndex        =   7
      Top             =   3120
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin ScottsLED.ForgeLEDc ForgeLEDc1 
      Height          =   420
      Left            =   2640
      TabIndex        =   6
      Top             =   1920
      Width           =   420
      _ExtentX        =   741
      _ExtentY        =   741
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Configurar"
      Height          =   375
      Left            =   120
      TabIndex        =   5
      Top             =   1080
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Atualizar"
      Height          =   375
      Left            =   9480
      TabIndex        =   2
      Top             =   600
      Width           =   1215
   End
   Begin VB.Frame Frame5 
      Caption         =   "DIO4"
      Height          =   615
      Left            =   7680
      TabIndex        =   17
      Top             =   1200
      Width           =   3015
      Begin VB.TextBox Text5 
         Height          =   285
         Left            =   120
         TabIndex        =   53
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check5 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   24
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label20 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   60
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label10 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   31
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame6 
      Caption         =   "DIO5"
      Height          =   615
      Left            =   7680
      TabIndex        =   18
      Top             =   1920
      Width           =   3015
      Begin VB.TextBox Text6 
         Height          =   285
         Left            =   120
         TabIndex        =   54
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check6 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   25
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label21 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   61
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label11 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   32
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame7 
      Caption         =   "DIO6"
      Height          =   615
      Left            =   7680
      TabIndex        =   19
      Top             =   3480
      Width           =   3015
      Begin VB.TextBox Text7 
         Height          =   285
         Left            =   120
         TabIndex        =   55
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check7 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   26
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label22 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   62
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label12 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   33
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame8 
      Caption         =   "DIO7"
      Height          =   615
      Left            =   7680
      TabIndex        =   20
      Top             =   4200
      Width           =   3015
      Begin VB.TextBox Text8 
         Height          =   285
         Left            =   120
         TabIndex        =   56
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check8 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   27
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label23 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   63
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label13 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   34
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame9 
      Caption         =   "DIO8"
      Height          =   615
      Left            =   7680
      TabIndex        =   21
      Top             =   4920
      Width           =   3015
      Begin VB.TextBox Text9 
         Height          =   285
         Left            =   120
         TabIndex        =   57
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check9 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   28
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label24 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   64
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label14 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   35
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame2 
      Caption         =   "DIO1"
      Height          =   1095
      Left            =   120
      TabIndex        =   15
      Top             =   2520
      Width           =   3015
      Begin AUDIOCONTROLS2Lib.Knob Knob2 
         Height          =   735
         Left            =   840
         TabIndex        =   37
         Top             =   240
         Width           =   735
         _Version        =   65536
         _ExtentX        =   1296
         _ExtentY        =   1296
         _StockProps     =   0
         Min             =   0
         Max             =   1023
      End
      Begin AUDIOCONTROLS2Lib.Knob Knob1 
         Height          =   735
         Left            =   120
         TabIndex        =   36
         Top             =   240
         Width           =   735
         _Version        =   65536
         _ExtentX        =   1296
         _ExtentY        =   1296
         _StockProps     =   0
         Min             =   1
         Max             =   15
         Position        =   1
      End
      Begin VB.CheckBox Check2 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2640
         TabIndex        =   22
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label15 
         Caption         =   "PWM"
         Height          =   255
         Left            =   1560
         TabIndex        =   38
         Top             =   720
         Width           =   495
      End
      Begin VB.Label Label7 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1680
         TabIndex        =   29
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame4 
      Caption         =   "DIO3"
      Height          =   615
      Left            =   120
      TabIndex        =   45
      Top             =   4920
      Width           =   3015
      Begin VB.TextBox Text4 
         Height          =   285
         Left            =   120
         TabIndex        =   52
         Top             =   240
         Width           =   735
      End
      Begin VB.CheckBox Check4 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   46
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label19 
         Caption         =   "V"
         Height          =   255
         Left            =   960
         TabIndex        =   59
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label9 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   47
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "DIO0"
      Height          =   615
      Left            =   120
      TabIndex        =   48
      Top             =   1800
      Width           =   3015
      Begin VB.CheckBox Check1 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2040
         TabIndex        =   49
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label6 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1200
         TabIndex        =   50
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Frame Frame3 
      Caption         =   "DIO2"
      Height          =   1095
      Left            =   120
      TabIndex        =   16
      Top             =   3720
      Width           =   3015
      Begin VB.TextBox Text3 
         Height          =   285
         Left            =   1680
         TabIndex        =   51
         Top             =   720
         Width           =   735
      End
      Begin VB.TextBox Text2 
         Height          =   285
         Left            =   120
         TabIndex        =   41
         Top             =   720
         Width           =   975
      End
      Begin VB.TextBox Text1 
         Height          =   285
         Left            =   120
         TabIndex        =   40
         Top             =   240
         Width           =   975
      End
      Begin VB.CheckBox Check3 
         Caption         =   "Check1"
         Height          =   195
         Left            =   2160
         TabIndex        =   23
         Top             =   240
         Width           =   255
      End
      Begin VB.Label Label18 
         Caption         =   "V"
         Height          =   255
         Left            =   2520
         TabIndex        =   58
         Top             =   720
         Width           =   375
      End
      Begin VB.Label Label16 
         Caption         =   "Hz"
         Height          =   255
         Left            =   1200
         TabIndex        =   42
         Top             =   720
         Width           =   255
      End
      Begin VB.Label Label8 
         Caption         =   "High/Low "
         Height          =   255
         Left            =   1320
         TabIndex        =   30
         Top             =   240
         Width           =   855
      End
   End
   Begin VB.Label Label27 
      Caption         =   "°C"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   615
      Left            =   8400
      TabIndex        =   67
      Top             =   600
      Width           =   375
   End
   Begin VB.Label Label26 
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   495
      Left            =   7560
      TabIndex        =   66
      Top             =   600
      Width           =   855
   End
   Begin VB.Label Label25 
      Height          =   255
      Left            =   3000
      TabIndex        =   65
      Top             =   360
      Width           =   615
   End
   Begin VB.Label Label17 
      Caption         =   "Número Dispositivo"
      Height          =   375
      Left            =   1560
      TabIndex        =   44
      Top             =   1080
      Width           =   855
   End
   Begin VB.Label Label5 
      Caption         =   "Versão Firmware:"
      Height          =   255
      Left            =   1680
      TabIndex        =   39
      Top             =   360
      Width           =   1335
   End
   Begin VB.Image Image2 
      Height          =   5700
      Left            =   3360
      Picture         =   "Form1.frx":0000
      Stretch         =   -1  'True
      Top             =   240
      Width           =   4050
   End
   Begin VB.Label Label4 
      Caption         =   "Easy Lab I/O"
      Height          =   255
      Left            =   2280
      TabIndex        =   4
      Top             =   120
      Width           =   975
   End
   Begin VB.Label Label3 
      Caption         =   "Modelo:"
      Height          =   255
      Left            =   1680
      TabIndex        =   3
      Top             =   120
      Width           =   735
   End
   Begin VB.Label Label2 
      Alignment       =   2  'Center
      BackColor       =   &H000000FF&
      Caption         =   "NOK"
      Height          =   255
      Left            =   9840
      TabIndex        =   1
      Top             =   120
      Width           =   855
   End
   Begin VB.Label Label1 
      Caption         =   "Status Conexão:"
      Height          =   255
      Left            =   8520
      TabIndex        =   0
      Top             =   120
      Width           =   1215
   End
   Begin VB.Image Image1 
      Height          =   870
      Left            =   0
      Picture         =   "Form1.frx":214B
      Top             =   0
      Width           =   1560
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Check1_Click()
Call Sendoutckb
End Sub

Private Sub Check2_Click()
Call Sendoutckb
End Sub

Private Sub Check3_Click()
Call Sendoutckb
End Sub

Private Sub Check4_Click()
Call Sendoutckb
End Sub

Private Sub Check5_Click()
Call Sendoutckb
End Sub

Private Sub Check6_Click()
Call Sendoutckb
End Sub

Private Sub Check7_Click()
Call Sendoutckb
End Sub

Private Sub Check8_Click()
Call Sendoutckb
End Sub

Private Sub Check9_Click()
Call Sendoutckb
End Sub

Private Sub Combo1_Click()
dev = Combo1.ListIndex
Call Sendoutckb

End Sub

Private Sub Command1_Click()
Call Getinfo
Call Form_Load
End Sub

Private Sub Command2_Click()
UserForm1.Show
End Sub


Private Sub Form_Load()
Dim tt(0 To 1) As String
dev = 0
Call Getinfo
ConfigFile1.ConfigLoad App.Path & "\data.txt"
For i = 0 To 8
ddr(i) = ConfigFile1.GetValue("ddr" & i)
AdcE(i) = ConfigFile1.GetValue("AdcE" & i)
Next i
Pf = ConfigFile1.GetValue("pf")
Pd = ConfigFile1.GetValue("pd")
Icpen = ConfigFile1.GetValue("icpen")
If ConfigFile1.GetValue("pwmen") = "True" Then PWMen = True

AdcRes = ConfigFile1.GetValue("adcres")
UserForm1.Show
wait (0.5)
Call UserForm1.CommandButton2_Click



End Sub

Private Sub Form_Unload(Cancel As Integer)
'ConfigFile1.ConfigLoad App.Path & "\Data.txt"
'Call ConfigFile1.WriteValue("x", 1)
'ConfigFile1.ConfigSave App.Path & "\Data.txt"

For i = 0 To 8
Call ConfigFile1.WriteValue("ddr" & i, CStr(ddr(i)))
Call ConfigFile1.WriteValue("AdcE" & i, CStr(AdcE(i)))
Next i
Call ConfigFile1.WriteValue("pf", CStr(Pf))
Call ConfigFile1.WriteValue("pd", CStr(Pd))
Call ConfigFile1.WriteValue("pwmen", CStr(PWMen))
Call ConfigFile1.WriteValue("icpen", CStr(Icpen))
Call ConfigFile1.WriteValue("adcres", CStr(AdcRes))
'Worksheets("data").Cells(10, 1) = 0
'If PWMen = True Then Worksheets("data").Cells(10, 1) = 1
'Worksheets("data").Cells(11, 1) = ComboBox3.ListIndex
'Worksheets("data").Cells(12, 1) = TextBox1.Text
'Worksheets("config").Cells(12, 1) = ComboBox3.ListIndex
'Worksheets("config").Cells(12, 2) = TextBox1.Text
'Worksheets("data").Cells(13, 1) = Icpen

ConfigFile1.ConfigSave App.Path & "\Data.txt"

End Sub



Private Sub Knob1_PositionChanged(ByVal nPosition As Integer)
If PWMen = True Then Call SetPWM(dev, Knob1.Position, Knob2.Position)
End Sub

Private Sub Knob2_PositionChanged(ByVal nPosition As Integer)
If PWMen = True Then Call SetPWM(dev, Knob1.Position, Knob2.Position)
End Sub

Private Sub TabStrip1_Click()

End Sub

Private Sub Timer1_Timer()
Dim DataIn As Integer

DataIn = 0
Call GetInPorts(dev, DataIn) ' Read Data in
Call dectobin(DataIn, Temp())

Form1.ForgeLEDc1.LEDstate = Temp(0)
Form1.ForgeLEDc2.LEDstate = Temp(1)
Form1.ForgeLEDc3.LEDstate = Temp(2)
Form1.ForgeLEDc4.LEDstate = Temp(3)
Form1.ForgeLEDc5.LEDstate = Temp(4)
Form1.ForgeLEDc6.LEDstate = Temp(5)
Form1.ForgeLEDc7.LEDstate = Temp(6)
Form1.ForgeLEDc8.LEDstate = Temp(7)
Form1.ForgeLEDc9.LEDstate = Temp(8)

If Icpen <> 2 Then
Call DoGetIcp(dev, IcpF, IcpC)
Text1.Text = IcpC
On Error Resume Next
If Icpen = 1 Then IcpF = 1500000 / IcpF
On Error Resume Next
If Icpen = 0 Then IcpF = 11718.75 / IcpF
On Error Resume Next
Text2.Text = IcpF
End If

Call GetTemp(dev, Temp(0))
Label26.Caption = Str$(Temp(0) / 10)
If (Temp(0) / 10 - Int(Temp(0) / 10)) = 0 Then Label26.Caption = Str$(Temp(0) / 10) & ".0"

If AdcRes = 0 Then GoTo Termina
If AdcRes = 12 Then
Call ReadAllAdc(dev, Adc)
If AdcE(2) = 1 Then Form1.Text3 = Adc(0) / 10000
If AdcE(3) = 1 Then Form1.Text4 = Adc(1) / 10000
If AdcE(4) = 1 Then Form1.Text5 = Adc(2) / 10000
If AdcE(5) = 1 Then Form1.Text6 = Adc(3) / 10000
If AdcE(6) = 1 Then Form1.Text7 = Adc(4) / 10000
If AdcE(7) = 1 Then Form1.Text8 = Adc(5) / 10000
If AdcE(8) = 1 Then Form1.Text9 = Adc(6) / 10000
GoTo Termina
End If

For i = 0 To 6
Temp(0) = 0
If AdcE(2 + i) = 1 Then Call ReadAdc(dev, AdcRes, 0, i + 2, 1, adcx(i))
Next i
Form1.Text3 = adcx(0) / 10000
Form1.Text4 = adcx(1) / 10000
Form1.Text5 = adcx(2) / 10000
Form1.Text6 = adcx(3) / 10000
Form1.Text7 = adcx(4) / 10000
Form1.Text8 = adcx(5) / 10000
Form1.Text9 = adcx(6) / 10000

Termina: End Sub
