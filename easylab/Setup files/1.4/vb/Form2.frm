VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   6285
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   9975
   LinkTopic       =   "Form2"
   ScaleHeight     =   6285
   ScaleWidth      =   9975
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer1 
      Interval        =   250
      Left            =   1680
      Top             =   5040
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   375
      Left            =   3360
      TabIndex        =   0
      Top             =   4080
      Width           =   1575
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Dim x(10, 0) As Integer

x(1, 0) = 1
x(10, 0) = 2

With MSChart1
.chartType = VtChChartType2dLine
.ShowLegend = True
.ChartData = x
End With



End Sub




Private Sub Timer1_Timer()
Dim x(10, 0) As Integer
Dim i As Integer
Dim adc As Long

Call ReadAdc(0, 10, 1, adc)

x(i, 0) = adc
i = i + 1
If i = 10 Then i = 0


With MSChart1
'.chartType = VtChChartType2dLine
'.ShowLegend = True
.ChartData = x
End With



End Sub


Private Sub Form_Load()
k = 0
MSChart1.DrawMode = VtChDrawModeBlit
End Sub
