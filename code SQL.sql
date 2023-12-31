USE [master]
GO
/****** Object:  Database [AssPRJ]    Script Date: 11/3/2023 1:36:44 AM ******/
CREATE DATABASE [AssPRJ]
GO
USE [AssPRJ]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[customerName] [varchar](100) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[roleId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[amount] [int] NULL,
	[accountId] [int] NULL,
	[createAt] [datetime] NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NULL,
	[productId] [int] NULL,
	[orderId] [int] NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[productID] [int] IDENTITY(1,1) NOT NULL,
	[typeID] [int] NULL,
	[productName] [nvarchar](max) NOT NULL,
	[price] [int] NOT NULL,
	[stockQuantity] [int] NOT NULL,
	[image] [nvarchar](max) NULL,
 CONSTRAINT [PK__Products__B40CC6EDAEC70205] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductTypes]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductTypes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/3/2023 1:36:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (1, N'Nguyen Van A', N'a.nguyen@email.com', N'password1234', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (2, N'Tran Thi B', N'b.tran@email.com', N'password5678', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (3, N'Le Van C', N'c.le@email.com', N'password9012', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (4, N'Pham Thi D', N'd.pham@email.com', N'password3456', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (5, N'Hoang Van E', N'e.hoang@email.com', N'password7890', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (6, N'Vu Thi F', N'f.vu@email.com', N'passwordabcd', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (7, N'Bui Van G', N'g.bui@email.com', N'passwordefgh', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (8, N'Do Thi H', N'h.do@email.com', N'passwordijkl', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (9, N'Ly Van I', N'i.ly@email.com', N'passwordmnop', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (10, N'Dang Thi J', N'j.dang@email.com', N'passwordqrst', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (11, N'huy322003', N'nhhuy322003@gmail.com', N'1234', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (12, N'user', N'1', N'1', 2)
INSERT [dbo].[Customer] ([id], [customerName], [email], [password], [roleId]) VALUES (13, N'admin', N'admin@gmail.com', N'1', 1)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([id], [amount], [accountId], [createAt]) VALUES (1, 550000, 12, CAST(N'2023-11-02T00:00:00.000' AS DateTime))
INSERT [dbo].[Order] ([id], [amount], [accountId], [createAt]) VALUES (2, 550000, 12, CAST(N'2023-11-02T00:00:00.000' AS DateTime))
INSERT [dbo].[Order] ([id], [amount], [accountId], [createAt]) VALUES (3, 1300000, 12, CAST(N'2023-11-02T23:40:35.197' AS DateTime))
INSERT [dbo].[Order] ([id], [amount], [accountId], [createAt]) VALUES (4, 1850000, 12, CAST(N'2023-11-03T01:17:51.180' AS DateTime))
INSERT [dbo].[Order] ([id], [amount], [accountId], [createAt]) VALUES (5, 550000, 12, CAST(N'2023-11-03T01:23:31.437' AS DateTime))
SET IDENTITY_INSERT [dbo].[Order] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (1, 1, 1, 2)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (2, 1, 2, 2)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (3, 4, 2, 3)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (4, 1, 3, 3)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (5, 2, NULL, 4)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (6, 4, NULL, 4)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (7, 1, NULL, 4)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (8, 1, 1, 5)
INSERT [dbo].[OrderDetails] ([id], [quantity], [productId], [orderId]) VALUES (9, 1, 2, 5)
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (1, 1, N'Áo sơ mi trắng', 250000, 100, N'/Clothes_Shop/images/QR Hoàng hoàng.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (2, 1, N'Qu?n jeans xanh', 300000, 80, N'/Clothes_Shop/images/Tuyển sinh ENW.png')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (3, 1, N'Áo thun den', 150000, 120, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (4, 4, N'Qu?n short d?', 180000, 90, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (5, 5, N'Ð?m d? ti?c tím', 500000, 50, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (6, 6, N'Váy ng?n h?ng', 350000, 70, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (7, 7, N'Áo khoác vàng', 400000, 60, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (8, 8, N'Qu?n tây den', 280000, 110, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (9, 9, N'Áo len xanh lá', 230000, 130, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (10, 10, N'Váy maxi nâu', 450000, 65, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (11, 1, N'Áo tanktop màu den', 150000, 100, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (12, 12, N'Qu?n jogger xám', 250000, 90, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (13, 13, N'Áo ba l? tr?ng', 120000, 110, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (14, 14, N'Qu?n legging den', 200000, 80, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (15, 15, N'Ð?m suông hoa', 400000, 60, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (16, 16, N'Váy body d?', 350000, 70, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (17, 17, N'Áo blazer n? xanh navy', 500000, 55, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (18, 18, N'Qu?n khaki nâu', 300000, 95, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (19, 19, N'Áo crop-top tr?ng', 170000, 105, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
INSERT [dbo].[Products] ([productID], [typeID], [productName], [price], [stockQuantity], [image]) VALUES (20, 20, N'Váy midi xanh duong', 450000, 65, N'/Clothes_Shop/images/398215768_651275977186923_3166588347190681380_n.jpg')
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[ProductTypes] ON 

INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (1, N'Áo so mi')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (2, N'Qu?n jeans')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (3, N'Áo thun')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (4, N'Qu?n short')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (5, N'Ð?m d? ti?c')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (6, N'Váy ng?n')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (7, N'Áo khoác')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (8, N'Qu?n tây')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (9, N'Áo len')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (10, N'Váy maxi')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (11, N'Áo tanktop')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (12, N'Qu?n jogger')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (13, N'Áo ba l?')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (14, N'Qu?n legging')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (15, N'Ð?m suông')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (16, N'Váy body')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (17, N'Áo blazer')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (18, N'Qu?n khaki')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (19, N'Áo crop-top')
INSERT [dbo].[ProductTypes] ([id], [name]) VALUES (20, N'Váy midi')
SET IDENTITY_INSERT [dbo].[ProductTypes] OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([id], [name]) VALUES (1, N'admin')
INSERT [dbo].[Role] ([id], [name]) VALUES (2, N'user')
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Customer__AB6E6164E6882F19]    Script Date: 11/3/2023 1:36:44 AM ******/
ALTER TABLE [dbo].[Customer] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Order] ADD  CONSTRAINT [DF_Table_1_createAt]  DEFAULT (getdate()) FOR [createAt]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Role] FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Role]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK__Products__TypeID__398D8EEE] FOREIGN KEY([typeID])
REFERENCES [dbo].[ProductTypes] ([id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK__Products__TypeID__398D8EEE]
GO
USE [master]
GO
ALTER DATABASE [AssPRJ] SET  READ_WRITE 
GO
