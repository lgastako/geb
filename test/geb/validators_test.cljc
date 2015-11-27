(ns geb.validators-test
  (:require #?(:clj  [clojure.test :refer :all]
               :cljs [cljs.test :refer [deftest is testing] :include-macros true])
            [geb.validators :as validate]))

(deftest I-test
  (testing "Strings ending with `I` validate."
    (is (= nil
           (validate/I "MI")))
    (is (= nil
           (validate/I "MIII")))
    (is (= nil
           (validate/I "MUUUI")))
    (is (= nil
           (validate/I "MUIUIUI"))))

  (testing "Strings not ending with `I` do not validate."
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/I "MU")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/I "M")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/I "MUF")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/I "MIU")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/I "MIIIIIIIU")))))

(deftest II-test
  (testing "Strings beginning with `M` validate."
    (is (= nil
           (validate/II "M")))
    (is (= nil
           (validate/II "MMMM")))
    (is (= nil
           (validate/II "MI")))
    (is (= nil
           (validate/II "MU")))
    (is (= nil
           (validate/II "MIUIUIU"))))

  (testing "Strings not beginning with `M` do not validate."
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/II "I")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/II "U")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/II "IUIUIUIU")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/II "IM")))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/II "UM")))))

(deftest III-test
  (testing "Strings that contain `III` validate."
    (is (= nil
           (validate/III "III" 0)))
    (is (= nil
           (validate/III "MIII" 0)))
    (is (= nil
           (validate/III "MIIIU" 0)))
    (is (= nil
           (validate/III "MIIIIIIIIIIII" 0)))
    (is (= nil
           (validate/III "MUUUUUUUUUUUIIIUUUUUUUU" 0)))
    ;; TODO n <> 0 tests
    )

  (testing "Strings that do not contain `III` do not validate."
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/III "M" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/III "M" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/III "M" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/III "M" 0)))
    ;; TODO: n <> 0 tests
    ))

(deftest IV-test
  (testing "Strings that contain `UU` validate."
    (is (= nil
           (validate/IV "UU" 0)))
    (is (= nil
           (validate/IV "MUU" 0)))
    (is (= nil
           (validate/IV "MIIUUIIUIU" 0)))
    ;; TODO: n <> 0 tests
    )

  (testing "Strings that do not contain `UU` do not validate."
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/IV "M" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/IV "MMM" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/IV "MIIII" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/IV "MIUIUIU" 0)))
    (is (thrown? #?(:clj Exception :cljs js/Error)
                 (validate/IV "MUI" 0)))
    ;; TODO: n <> 0 tests
    ))

(run-tests)
