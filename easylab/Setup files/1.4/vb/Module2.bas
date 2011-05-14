Attribute VB_Name = "Module2"
Public Sub Sendoutckb()
For i = 0 To 8
temp(i) = 0
Next i

If Form1.Check1 = 1 Then temp(0) = 1
If Form1.Check2 = 1 Then temp(1) = 1
If Form1.Check3 = 1 Then temp(2) = 1
If Form1.Check4 = 1 Then temp(3) = 1
If Form1.Check5 = 1 Then temp(4) = 1
If Form1.Check6 = 1 Then temp(5) = 1
If Form1.Check7 = 1 Then temp(6) = 1
If Form1.Check8 = 1 Then temp(7) = 1
If Form1.Check9 = 1 Then temp(8) = 1

Call bintodec(temp(), temp(9))
Call SetOutputPorts(dev, temp(9))
End Sub

Public Sub bintodec(ByRef ddr() As Integer, ByRef dec As Integer)
dec = 0
For i = 0 To 8
dec = dec + ddr(i) * 2 ^ i
Next i
End Sub
Public Sub dectobin(ByVal dec As Integer, ByRef ddr() As Integer)

For i = 8 To 0 Step -1
    ddr(i) = 0
    If (2 ^ i) <= dec Then 'Transforma decimal para binario, fazendo separação de bits no vetor
        dec = dec - (2 ^ i)
        ddr(i) = 1
    End If
Next i
End Sub
Public Sub wait(delay As Single)

Dim t As Single

t = Timer

Do While Timer < t + delay
DoEvents
Loop
End Sub
