        window.onload = function () {
            var oBox = document.getElementById('box');
            var oH = document.querySelector('.hour');
            var oM = document.querySelector('.min');
            var oS = document.querySelector('.sec');

            //生成刻度 - 整点
            var N = 60;
            for (var i = 0; i < N; i++) {
                var oSpan = document.createElement('span');

                if (i % 5 == 0) {
                    oSpan.className = 'bs';
                    var num = i / 5 == 0 ? 12 : i / 5;
                    oSpan.innerHTML = '<em>' + num + '</em>'
                    oSpan.style.transform = 'rotate(' + (i * N) + 'deg)';
                    oSpan.children[0].style.transform = 'rotate(' + -i * 6 + 'deg)'

                } else {
                    oSpan.className = 'scale';
                }


                oBox.appendChild(oSpan);
                oSpan.style.transform = 'rotate(' + 6 * i + 'deg)'
            }


            //设置时间
            function clock() {
                var oDate = new Date();
                var h = oDate.getHours();
                var m = oDate.getMinutes() + 1;
                var s = oDate.getSeconds();
                var ms = oDate.getMilliseconds();

                oH.style.transform = 'rotate(' + (h * 30 + m / 60 * 30) + 'deg)';
                oM.style.transform = 'rotate(' + (m * 6 + s / 60 * 6) + 'deg)';
                oS.style.transform = 'rotate(' + (s * 6 + ms / 1000 * 6) + 'deg)';
            }

            clock();
            setInterval(clock, 30)


        }
