(ns gen
  (:require [hiccup.core :refer [html]]))

(defn template [body]
  (str "<!DOCTYPE html>"
       "<html><head> <meta charset=\"UTF-8\"> <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> </head><body>"
       body
       "</body></html>"))

(defn image [url label]
  [:div.image
   [:a {:href url :target "_blank"}
    [:img {:src url :width "900px"}]]
   [:div.label label]])

(defn video [url label]
  [:div
   [:iframe {:width "900px"
             :height "900px"
             :src url
             :frameborder "0"
             :allow "accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
             :allowfullscreen true}]
   [:div.label label]])

(def day1-2
  [{:type :image
    :label "Вечером мы приехали на ЖД станцию Имандра, одноименную с озером рядом."
    :url "https://sun9-39.userapi.com/qMiY4DntlOSmCcIMEnK5hInzz3Ikq1g-HYM7HQ/tuRDKa8JUiw.jpg"}
   {:type :image
    :url "https://sun9-63.userapi.com/D5wN_A-ya9G_ECrmJ7494pRiO424gkcwruXzag/jLyQeriVsqA.jpg"
    :label "Прошли около 7км и с заходом солнца разбили лагерь на берегу реки."}
   {:type :image
    :url "https://sun9-6.userapi.com/XpSF1mojSWTGXwCOTsRCQ3wOrXGIa8gnrYeGmw/jfU0obSYatg.jpg"
    :label "Утром с того же берега стало видно горы. Сегодня у нас разминочный поход налегке,
 почти все вещи оставили в лагере. Я взял только термос и дождевик."}
   {:type :image
    :url "https://sun9-53.userapi.com/HK4QKBuWQYs5Vyj_bYlfCqGZvfVphZPlT07z_Q/LbEPpicHmJ0.jpg"}
   {:type :image
    :url "https://sun9-32.userapi.com/RWaorHxOVgMIoS6Zk8KI3bnIYIAjX0miPpgqaw/TcSvHn24EIY.jpg"
    :label "Здесь решили перейти вброд не разуваясь. Не все камни были над водой, но если не долго
стоять в воде, ботинки не успевают промокнуть."}
   {:type :image
    :url "https://sun9-50.userapi.com/RW4ff1cj1VqccfN_oUNicp7NRe3wf-l4ZkJW4w/0UOZflxNPjA.jpg"}
   {:type :image
    :url "https://sun9-41.userapi.com/O0otgxQDXEqtv7bJV2SKEehTQp4LGWR5342TpA/zGLePtyJl1E.jpg"}
   {:type :image
    :url "https://sun9-64.userapi.com/vb7LL_XMgVksoq-n5lRsd5Bp6Tdid7BerTcs-A/rdDTDkR9lGc.jpg"}
   {:type :image
    :label "А эту речку перешли по бревнам, которые до нас кто-то оставил."
    :url "https://sun9-49.userapi.com/KznoLIbOM7rgE2AYU1e6IkF2qfGraSc1JxKd_w/HgpVHyevnoQ.jpg"}
   {:type :image
    :label "По этой тропе пойдем в сторону гор."
    :url "https://sun9-37.userapi.com/OQiq4dhztYYI9i8ASCr6unH7utOY1WQX5m806Q/dNCER3SNeAs.jpg"}
   {:type :image
    :label "На этой реке не нашли удобного места, чтобы перейти в обуви, поэтому большинство разулись и
 закатали штаны. Если бы я взял с собой сандали, было бы удобнее переходить. Вода невероятно прозрачная
и ледяная."
    :url "https://sun9-73.userapi.com/k7YnTQ7QR6wCFI0yw_GxLeMa9ReBFD7ShILSLw/iYu1OuxcfdI.jpg"}
   {:type :image
    :label "На том берегу одеваемся обратно и продолжаем идти. От ходьбы ноги сразу же опять согреваются."
    :url "https://sun9-56.userapi.com/UPp8ZJ7UyWifrcj6s0jVF6HDTCXJM1fTaajtoA/lDtyfU7K7G8.jpg"}
   {:type :image
    :label "Вышли на поляну, покрытую мхом ягелем, который едят олени. Говорят, он и для людей съедобен.
Я попробовал, на вкус горький и тяжело жуется."
    :url "https://sun9-47.userapi.com/r3oAcONdJMdakm22fmb90ElGMGyISdWpKQiFQw/MENZpgl48yU.jpg"}
   {:type :image
    :label "На эту гору мы не идем, а обойдем слева."
    :url "https://sun9-59.userapi.com/sqb3fy1AtbsAJ-gA1jlAviKOLOFnEml35Spd-Q/UqhVvuvVhEM.jpg"}
   {:type :image
    :url "https://sun9-7.userapi.com/nU2yl0YtdNoSv5VQdv9hf9SN-521C340UxqaDA/4qYgt4HC6jo.jpg"}
   {:type :image
    :label "Идем вдоль практически сухого русла реки. Сейчас уже почти весь снег на вершинах расстаял за лето,
поэтому реки мелководные или полностью пересохшие."
    :url "https://sun9-7.userapi.com/nlPIUy_iLhzoPzHb6igf45rqcBOYof7116UagQ/gDJYxC6E2yA.jpg"}
   {:type :image
    :url "https://sun9-47.userapi.com/IymTQMTOgRx46JtuoRwsRaIDGviGaNVtvOWiSw/tEa55TRN6M8.jpg"}
   {:type :image
    :url "https://sun9-59.userapi.com/qDS2iMofrmq1L4WyoTY3P3CBgHqhfcaLcuaxHA/X_33a3li0is.jpg"}
   {:type :image
    :url "https://sun9-66.userapi.com/EEtXR0Paztg1Ue6NK3obYLwUVPp6o2SltFBVyw/LLYaRbD_ho4.jpg"}
   {:type :image
    :url "https://sun9-31.userapi.com/pm_P5syHXpGbVyHPqfR4iK6k1L0TKX6ZN95vGQ/PFLeRyzO85g.jpg"}
   {:type :image
    :url "https://sun9-40.userapi.com/0dvQVpvMBYK2Q8BY7oTr-0qk7fDUs64VYCciTQ/xuBrp1iMI7k.jpg"}
   {:type :image
    :label "Мы обошли гору и сейчас у нас привал, перед тем как начать подниматься на перевал Ущелье Мертвых."
    :url "https://sun9-67.userapi.com/EwjKvAmcDa1GjNcRsvU6XLWZOkczwyizTJQqZQ/HKujKt8x8Pk.jpg"}
   {:type :image
    :label "Мы уже поднялись достаточно высоко, кусты и деревья здесь уже не растут. Но ягоды все еще есть."
    :url "https://sun9-31.userapi.com/d4REyhwkrKYXiWE6HlaR1uf34XViOlSWLteREw/fn4h4KMRmEw.jpg"}
   {:type :image
    :label "Поднимаемся"
    :url "https://sun9-30.userapi.com/d0nKYwdjNvX-lvO60WIPJ7bayuZ2L0eJ7toteA/f0B52iNPkIs.jpg"}
   {:type :image
    :label "Вид с перевала"
    :url "https://sun9-69.userapi.com/-LZvebpwQZvnLVQ6Z6KYKPLtjPtU4KRQJIux0g/PajDIkXWKFc.jpg"}
   {:type :image
    :label "Я ЗДЕСЬ БЫЛ"
    :url "https://sun9-58.userapi.com/5JncdUeVsckhjsAcI0IuPrHCJspRNXA6at9rzA/B-OMNz0hCT8.jpg"}
   {:type :image
    :label "А вот и сам перевал."
    :url "https://sun9-76.userapi.com/rDLRe4bAllCun1Xt46VMYIwHHpYPUPcPoMZ_OQ/bDzDy3p3HCg.jpg"}
   {:type :image
    :url "https://sun9-73.userapi.com/kJgZO2jOXY3ywlLM7zBS-dpt-O7f2bG2d3pneQ/tH60hXfJsXE.jpg"}
   {:type :image
    :url "https://sun9-22.userapi.com/yV-y-5ycpmtBW01yODJj51aJvbl94nhZMlL0Xg/Kuf_4PKyHfY.jpg"}
   {:type :image
    :url "https://sun9-57.userapi.com/sFzc0Bbv3ifwfVvdvbvCsv7p3R3-5LeAXr2B8w/BgsV1IbdJGg.jpg"}
   {:type :image
    :label "Здесь сильный ветер, поэтому укрываемся в ложбинке и обедаем. Едим бутерброды с салом и сыром, а также чай из термоса."
    :url "https://sun9-9.userapi.com/zHhAO_ajvXzFbN76GtmHj3L1myll3Kq0bKMEpw/Y53xREsKQYU.jpg"}
   {:type :image
    :url "https://sun9-2.userapi.com/ysXRw3MAjjtqSrsuHA_bKYFVQ4SBIrYbqJKkJg/Px8sZcA8zJc.jpg"}
   {:type :image
    :label "Вид по другую сторону ущелья. Озеро Имандра."
    :url "https://sun9-32.userapi.com/NKQf76GwzeRBCaOiYIrcMkUrBrXZB1DXwv5Vjg/X91IQdaB0nE.jpg"}
   {:type :image
    :url "https://sun9-14.userapi.com/rlE1MBKdifToaIa3GSW4zKWjDOwAEnBPj63b3w/vhXn0QFX3mQ.jpg"}
   {:type :image
    :url "https://sun9-62.userapi.com/jORELNG0fhyIzXVvTO7GyCO96gCZHmV1PCYOBA/G2jRt1QiXoc.jpg"}
   {:type :image
    :label "Дальше мы пройдем еще один перевал и будем двигаться к вершине."
    :url "https://sun9-32.userapi.com/mdtCS1Evtu_QAtSN5J-csOxbW3KQJZJvQJyknQ/JUIXhRJbfX8.jpg"}
   {:type :video
    :label "Был дождь, поэтому надели дождевики."
    :url "https://www.youtube.com/embed/kY7V4L10PLw"}
   {:type :image
    :url "https://sun9-43.userapi.com/x_YjrSr72eq3RVd3jY-5vFRuS3-oXs72mYt5vw/kcOiCE26aoI.jpg"}
   {:type :image
    :url "https://sun9-22.userapi.com/kk-m15PaX9VRd45uA7iCOe35PUfRHrRfHNoaog/IBKgvBr6pDc.jpg"}
   {:type :image
    :label "Прошли второй перевал, который я почему-то не сфотографировал.
 Отличался от первого отсутствием тропы, пробирались просто по куче камней. Вид, открывшийся после перевала."
    :url "https://sun9-58.userapi.com/Sw0IzdcjkmFQNRKDUMGZkzwYl8WV25_xe1mR2g/ysz86eGPgUc.jpg"}
   {:type :image
    :url "https://sun9-74.userapi.com/uJ8kigu5QPD24yTXuOTe9yKBRjozBQrIekOTlw/OtqTQxfzp74.jpg"}
   {:type :image
    :url "https://sun9-66.userapi.com/dVRELZeYsBSp1g1qNZpq7dzDPRmItCNG90oLHA/iaEo5cve-Go.jpg"}
   {:type :image
    :url "https://sun9-30.userapi.com/RJjR4rwQ-i6XHq6UPm_w_RRevyAslu30GFuMSQ/5zb6gU-RRU8.jpg"}
   {:type :image
    :url "https://sun9-58.userapi.com/Dr6lXth9IsGLp48VI2UsnTEjtqf9pmNLBsSdmQ/3t_L9KJeEVY.jpg"}
   {:type :image
    :label "Более полный вид на озеро Имандра."
    :url "https://sun9-41.userapi.com/_4ANTZ5yTPQ3eRUbKiH5A11JVdJYe4FYuRDU6w/RfK2LXW0Pi4.jpg"}
   {:type :image
    :url "https://sun9-65.userapi.com/x7_ndkRewuWfoeJIe3YhdX6NkPXXMpMUgLV69A/Eji821KkvKk.jpg"}
   {:type :image
    :label "К вершине."
    :url "https://sun9-39.userapi.com/SaFUI-HWp5ZuWmZGRm0M5mIMCxYau8ptcB73Sw/tFNVa6c5d2U.jpg"}
   {:type :video
    :url "https://www.youtube.com/embed/V9Nftwc5oMQ"}
   {:type :image
    :url "https://sun9-16.userapi.com/RlQc01rH3aU_vRN5Yslb-IYBY9SqJdWTviKb9w/r5Awtws7EeU.jpg"}
   {:type :video
    :url "https://www.youtube.com/embed/G2SrzAtYFeE"}
   {:type :image
    :url "https://sun9-51.userapi.com/1Z4Fe96DH3bvYgsSxoBaov78yLLC1eq3hn-fmA/nWqQYl4Ap0o.jpg"}
   {:type :image
    :url "https://sun9-24.userapi.com/0pCmeAslb81eIxnn6u6rliqdBWkj7KPXoBwTzQ/GtGMzNxEUmE.jpg"}
   {:type :image
    :url "https://sun9-36.userapi.com/23_wIMHuCbnvC1mJI65yNfg39N1lemc8OO_Xgw/JFb57Yi3KN8.jpg"}
   {:type :image
    :url "https://sun9-31.userapi.com/xcF2QsrwmaZRY4h_2CccONuyVjn4wSJFIoInxw/P7O1wPTkq8Q.jpg"}
   {:type :image
    :label "И вниз."
    :url "https://sun9-48.userapi.com/7uzdGYYldNMjNxbdXYjXke7xcwbsdcXYy9HlWA/KDuGOYE-28g.jpg"}
   {:type :image
    :label "В кустах иногда встречаются куропатки."
    :url "https://sun9-39.userapi.com/QbqLQukIGjayUcOcAXhIiSbMSDeT-AYc7swpSQ/0h2c36RcJ7o.jpg"}
   {:type :image
    :url "https://sun9-36.userapi.com/YyJ4AvqqLfHgMdO4XkR7_bggOeXtF_nZ0hXGXA/beloaq8GanM.jpg"}
   {:type :image
    :url "https://sun9-7.userapi.com/aRna_EJHsoGSKNgNlmjsLPzpHVNE3ZplEe5xIg/0VlRoejRNX4.jpg"}
   {:type :image
    :url "https://sun9-33.userapi.com/igLP0HjW4AIxlXH1XKFYC3EDVw-4Tsdsz2KwIw/5aMDmia87j0.jpg"}
   {:type :image
    :url "https://sun9-16.userapi.com/2CV7EQazR7aK3mBKLjJtBEeleffDhZNTx5fCBQ/pn1Rd8F97Pg.jpg"}

   ])

(defn gen []
  (->> day1-2
       (mapv (fn [{:keys [type url label]}]
               ((resolve (symbol type)) url label)))
       (apply vector :div.content)
       html
       template
       (spit "index.html")))

(gen)
