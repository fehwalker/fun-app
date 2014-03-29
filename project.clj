(defproject
  fun-test
  "0.1.0-SNAPSHOT"
  :repl-options
  {:init-ns fun-test.repl}
  :dependencies
  [[ring-server "0.3.1"]
   [com.h2database/h2 "1.3.175"]
   [environ "0.4.0"]
   [markdown-clj "0.9.41"]
   [com.taoensso/timbre "3.1.6"]
   [korma "0.3.0"]
   [org.clojure/clojure "1.6.0"]
   [com.taoensso/tower "2.0.2"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [selmer "0.6.4"]
   [lib-noir "0.8.1"]
   [compojure "1.1.6"]]
  :ring
  {:handler fun-test.handler/app,
   :init fun-test.handler/init,
   :destroy fun-test.handler/destroy}
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.2"]],
    :env {:dev true}}}
  :url
  "http://example.com/FIXME"
  :plugins
  [[lein-ring "0.8.10"] [lein-environ "0.4.0"]]
  :description
  "Messing around with Clojure and Luminus"
  :min-lein-version "2.0.0")
