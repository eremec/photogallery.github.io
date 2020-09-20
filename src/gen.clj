(ns gen
  (:require [hiccup.core :refer [html]]))

(defn template [body]
  (str "<!DOCTYPE html>"
       "<html><head> <meta charset=\"UTF-8\"> <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> </head><body>"
       body
       "</body></html>"))

(defn image [url label]
  [:div.image
   [:a {:href url}
    [:img {:src url :width "900px"}]]
   [:div.label label]])

(defn video [url label]
  (str "<div><iframe width=\"900px\" src="
       url
       "frameborder=\"0\" allow=\"accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"
       label
       "</div>"))

(def content
  [{:type :image
    :label "Вечером мы приехали на ЖД станцию Имандра, одноименную с озером рядом."
    :url "https://sun9-39.userapi.com/qMiY4DntlOSmCcIMEnK5hInzz3Ikq1g-HYM7HQ/tuRDKa8JUiw.jpg"}
   {:type :image
    :url "https://sun9-63.userapi.com/D5wN_A-ya9G_ECrmJ7494pRiO424gkcwruXzag/jLyQeriVsqA.jpg"
    :label "Прошли около 7км и с заходом солнца разбили лагерь на берегу реки."}
   #_{:type :video
    :label "Течет вода"
    :url "https://www.youtube.com/embed/tM6Kvw7rQ50"}])

(defn gen []
  (->> content
       (mapv (fn [{:keys [type url label]}]
               ((resolve (symbol type)) url label)))
       (apply vector :div.content)
       html
       template
       (spit "index.html")))
