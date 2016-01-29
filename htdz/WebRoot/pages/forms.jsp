<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>航天通信年薪试算</title>
    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <%@ include file="headbar.jsp" %>
            <%@ include file="menu.jsp" %>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">试算表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                                                           试算基数表单
                        </div>
                        <div class="panel-body">
                            <div class="row">
                              <div class="col-lg-10">
                                <div class="well">
                                  <h4>试算公式</h4>
                                  <p class="fa fa-star"> 党政正职绩效年薪（X）= 绩效基数（Y）× 绩效年薪系数（K）</p>
                                  <p class="fa fa-star"> 绩效基数（Y）= 绩效基数测算值（YC）× 利润贡献系数（S）× 调节系数（R0）</p>
                                  <p class="fa fa-star"> 绩效基数测算值（YC）＝G ×（12.5％z0＋12.5％x0＋12.5％j0＋37.5％y0＋12.5％L＋12.5％N）</p>
                                  <p class="fa fa-star"> 总资产规模系数[z0] = 0.8362×Z0^0.2159 [Z0：单位当年度总资产期末数与期初数的平均值（单位：亿元）]</p>
                                  <p class="fa fa-star"> 营业收入规模系数[x0] = 1.0532×X0^0.2084 [X0：单位当年度的营业收入（单位：亿元）]</p>
                                  <p class="fa fa-star"> 利润总额规模系数[y0] = 2.1366×Y0^0.1807[Y0：单位当年度的利润总额（单位：亿元）]</p>
                                  <p class="fa fa-star"> 净资产规模系数[j0] = 1.449×J0^0.1925[J0：单位当年度净资产（单位：亿元）]</p><br/>
                                  <p class="fa fa-star"> 利润总额增幅系数[L]：根据利润增幅系数分档获取</p><br/>
                                  <p class="fa fa-star"> 净资产收益率系数[N]：根据净资产收益率分档获取</p><br/>
                                  <p class="fa fa-star"> 利润贡献系数[S]：根据利润总额分档获取</p><br/>
                                  <p class="fa fa-star"> 调节系数（R0）取值范围为0.8～1.2，每年由集团公司核定。</p>
                             </div>
                           </div>
                        </div>
                       <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                       <div class="form-group">
                                            <label>Text Input</label>
                                            <input class="form-control">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
