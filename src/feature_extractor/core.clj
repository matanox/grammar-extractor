(ns feature-extractor.core (:gen-class))

(require '[instaparse.core :as instaparse])
(use 'criterium.core)

(def parser
  (instaparse/parser
    "S = {Any}{AB}{Any}
     Any = #'(?s).'
     AB = A B
     A = 'a'+
     B = 'b'+"))

(defn -main [s]
  (do
    (println "parsing" s)
    (println (instaparse/parses parser s))
    (bench (instaparse/parses parser s))))
