   M S B A M L   `   `   `  ����I  EWpfEjercicio04, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null/clr-namespace:WpfEjercicio04WpfEjercicio04  5   	       WpfEjercicio04.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   .localclr-namespace:WpfEjercicio04     5   	   -   5        $��
ventanaFrm��5	   	     � Title$  Gestión de reservas��5   	   $	��450��6%   $	��800��62    � 
ResizeMode$ CanResizeWithGrip=�5
   	   $	��440��5   .    � 	Resources 5      $   WpfEjercicio04.AsisteConverter   AsisteConverter��%   &	          5   
   6:   5      .��5      ]� .+�5   
   � $	��Top=�6   $��5q�6$    � ColumnDefinitions 5      �� 5      $��* �6#   �� 5      $
��auto �6#   �� 5      $��40 �6#   �� 5      $
��auto �6#   .+�5      �� -   5         ��Name$ 	txtFiltro��5      6+   �� 5      -   5         ��Name$ 
btnFiltrar��5      $��1��6)   $��80��69    �� 	IsDefault . .��6n   	Filtrar6w   �� 5      -   5        $ btnNueva��5      $��3��6'   $��80��67   .��6Y   Nueva6`   5      �� 5   
   $��Bottom=�6   ��5      �� 5      .R�5       �  5!      �� 5"      $��* �6/   �� 5#      $
��auto �6/   5%      5&      .@�5(      �� $��0��6   .��5)      �� -   5        $��tbFiltro��5)      $��
Sin filtro��6,   5*      �� 5+      $��1��6   .��5,      �� -   5        $��tbRegistros��5,      $��0 Registros��6/   5-      5.      �� 52   
   $��5q�6   .��53      �� -   5        $��
lvReservas��53       �� SelectionMode$ Single=�6\    �� View 54      �� 55      .P�56      �� 	 �� Width$		 100��6)   
 �� DisplayMemberBinding
 65   �� *Fecha+ �� StringFormat$ 
dd/MM/yyyy����57      �� 58   "   -   5        
 � Tag$ Fecha��58   Z   .��6f   Fecha6m   5:      �� 5;      $		 440��6)   -	   5        	gvcNombre��
 5;   H   �� *Nombre+��5<      �� 5=   "   -
   5        $ Nombre��5=   Z   .��6g   Nombre6o   5?      �� 5@      $		 100��6)   
 65   �� *
Comensales+��5A      �� 5B   "   -   5        $ 
Comensales��5B   Z   .��6k   
Comensales6w   5D      �� 5E      $		 100��6)   
 65   �� *Asiste+ �� 	Converter# [  ��5F      �� 5G   "   -   5        $ Asiste��5G   Z   .��6g   Asiste6o   5I      5J       � ContextMenu 5L      �� 5M      .@�5N      m� -   5         m�Name$ cmiNueva��5N   #   $��Nueva��65    m� Icon 5O      �� 5P   "   $��.\imagenes\add.png��6(   5R      m� 5S      -   5        $ cmiVer��5S   #   $	��Ver��63    5T      �� 5U   "   $��.\Imagenes\procedure.png��6(   5W      m� 5X      -   5        $ 	cmiBorrar��5X   #   $��Borrar��66    5Y      �� 5Z   "   $��.\imagenes\cancel.png��6(   5\      �� 5]      m� 5^      -   5        $ cmiConfirmar��5^   #   $��	Confirmar��69    5_      �� 5`   "   $��.\Imagenes\check.png��6(   5b      5c      5e      5f      5g      5h      