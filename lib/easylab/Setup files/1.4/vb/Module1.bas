Attribute VB_Name = "Module1"

Public Declare Function DoEEPROMRead Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal Address As Integer, ByRef DataInByte As Byte) As Long
Public Declare Function SetPWM Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal Divisor As Byte, ByVal Duty As Long) As Integer
Public Declare Function SetPortDirections Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal ddr As Long) As Integer
Public Declare Function GetPortDirections Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef DDRin As Integer) As Integer
Public Declare Function GetInPorts Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef DataIn As Integer) As Integer
Public Declare Function GetOutPorts Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef DataOut As Integer) As Integer
Public Declare Function SetOutputPorts Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal DataOut As Long) As Integer
Public Declare Function timeGetTime Lib "winmm.dll" () As Long 'tempo desde pc ligado
Public Declare Function Icen Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal fr As Long) As Long
Public Declare Function DoGetIcp Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef Freq As Long, ByRef counter As Long) As Long
Public Declare Function SearchDevices Lib "Easy_lab.dll" (ByRef ndevs As Byte) As Long
Public Declare Function ReadAdc Lib "Easy_lab.dll" (ByVal dev As Byte, ByVal Res As Byte, ByVal Modo As Byte, ByVal Porta As Byte, ByVal Ganho As Byte, ByRef Adc As Long) As Long
Public Declare Function ReadAllAdc Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef Adc As Variant) As Long
Public Declare Function GetTemp Lib "Easy_lab.dll" (ByVal dev As Byte, ByRef Temp As Integer) As Long

Global Temp(0 To 100) As Integer
Global Adc(0 To 6) As Variant
Global t As Variant
Global PWMen, P, PL As Boolean
Global AdcE(0 To 8), ddr(0 To 8) As Integer
Global k, i, Icpen, iL, a, tempA, Pd, Pf, Modelo As Integer
Global DDRA As Integer
Global AdcRes As Integer
Global ndevs As Byte
Global dev As Integer
Global IcpF, IcpC As Long
Global tempp As Variant
Global adcx(0 To 8) As Long



Public Sub Getinfo()
Form1.Label2.BackColor = 255
Form1.Label2.Caption = "NOK"
'Worksheets("home").Cells(1, 15).Interior.ColorIndex = 3

ndevs = 0
If SearchDevices(ndevs) = 0 Then

 'Worksheets("home").Cells(31, 8) = t
 Form1.Label2.Caption = "OK"
 Form1.Label2.BackColor = &HFF00&
 Form1.Label5.Caption = "Versão Firmware:"
 'Worksheets("home").Cells(1, 15).Interior.ColorIndex = 4
 
 Call DoEEPROMRead(0, 0, tempp)
 Modelo = tempp
 Select Case tempp
 Case 0
 Form1.Label4.Caption = "Easy Lab IO"
 Case 1
 Form1.Label4.Caption = "Easy Lab AG"
 Case 2
 Form1.Label4.Caption = "Easy Lab AG +"
 End Select
 
Call DoEEPROMRead(0, 1, tempp)
Form1.Label25.Caption = tempp
End If
  
Form1.Combo1.Clear
For i = 0 To ndevs - 1
Form1.Combo1.AddItem (i)
Next
On Error Resume Next
Form1.Combo1.ListIndex = 0
End Sub

