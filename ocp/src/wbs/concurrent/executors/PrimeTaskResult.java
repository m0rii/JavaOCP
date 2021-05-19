package wbs.concurrent.executors;

import java.math.BigInteger;

public class PrimeTaskResult {

        private BigInteger untergrenze;
        private BigInteger obergrenze;
        private BigInteger anzahl;

        public PrimeTaskResult(BigInteger untergrenze, BigInteger obergrenze, BigInteger anzahl) {
                this.untergrenze = untergrenze;
                this.obergrenze = obergrenze;
                this.anzahl = anzahl;
        }

        public BigInteger getUntergrenze() {
                return untergrenze;
        }

        public BigInteger getObergrenze() {
                return obergrenze;
        }

        public BigInteger getAnzahl() {
                return anzahl;
        }

}
