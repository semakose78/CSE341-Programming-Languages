;;Sema Köse
;;141044002
;;Project 01
(ns lexer.core
  (:require [clojure.string :refer (split split-lines trim escape)])
  (:require [clojure.zip :as z]))

(defn parser []
  (def input (slurp "/Users/semakose/eclipse-workspace/Project01/src/CoffeeSample.coffee"))
  (println input)
  (let [lineTokens (split-lines input)
        lineTokens-w-rule-names (->> lineTokens
                                     (map #(split % #" "))
                                     ;;(map (fn [[r b]] [(trim r)
                                     ;;(split (trim b)
                                     ;;#"\s+")]))
                                     (into []))]
    lineTokens-w-rule-names)
  ;;(def terminals (re-matcher #"[-+]+|[0-9]+|[a-zA-z]+|true-false" input))
  (def operators "+ - / * ( )")
  (def id "a b c d e f g h ı j k l m n o p q r s t u  w x y z")
  (def integerValue "0 1 2 3 4 5 6 7 8")
  (def binaryValue "true false")

  (def keywords (re-matcher #"and-or-not-equal-append-concat-set-for-while-if-then-else-true-false\d+" input))


  ;;(println (re-find operators))


  ;;(def binValue (re-find binaryValue))
  ;;(if (not= nil binaryValue)
  ;;  (println binaryValue)
  ;;(println (split-at 1 input))
  )


  (defn tokenizer []
  (let [terminals (re-matcher #"[-+]+|[0-9]+|[a-zA-z]+|true-false" input)]

    (loop [token (re-find terminals) ;loop starts with 2 set arguments
           res []]
      ;(println token)
        (if (.contains integerValue token)
          (println "IntegerValue"))
        (if (.contains id token)
          (println "Id"))
        (if (.contains operators token)
          (println "Operator"))
        (if (.contains binaryValue token)
          (println "BinaryValue"))
      (if-not token
        res
          (recur (re-find terminals)    ;loop with 2 new arguments
               (conj res token)))

      ))
    )

(parser)
(tokenizer)